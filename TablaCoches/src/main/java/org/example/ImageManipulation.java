package org.example;

import java.io.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.awt.Color;

public class ImageManipulation {

    static int h, w;

    public static void main(String[] args) {
        try {

            File fichImagen = new File("src/main/resources/ciervo.jpg");

            BufferedImage image = ImageIO.read(fichImagen);

            w = image.getWidth();
            h = image.getHeight();

            int[] inicial = new int[w * h];

            int[] resultadoR = new int[w * h];
            int[] resultadoG = new int[w * h];
            int[] resultadoB = new int[w * h];

            int[][] procesarR = new int[h][w];
            int[][] procesarG = new int[h][w];
            int[][] procesarB = new int[h][w];

            int[][] procesarBN = new int[h][w];

            int[][] binaria;

            int[] resultado = new int[w * h];

            // Pasar imagen a una matriz
            inicial = image.getRGB(0, 0, w, h, inicial, 0, w);


            // Procesa matriz mediante tu algoritmo
            // 1. Seleccionamos cada componente del color
            for (int i = 0; i < w * h; i++) {
                Color c = new Color(inicial[i]);
                resultadoR[i] = c.getRed(); //getRed, getGreen, getBlue, getAlpha orden:ARGB
                resultadoG[i] = c.getGreen();
                resultadoB[i] = c.getBlue();
            }

            // 2. Las pasamos a matriz bidimensional
            int k = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    procesarR[i][j] = resultadoR[k];
                    procesarG[i][j] = resultadoG[k];
                    procesarB[i][j] = resultadoB[k];
                    k++;
                }
            }


            // 3. Pasamos la imagen a blanco y negro
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {

                    // procesarBN[i][j]=(int)(0.2989*procesarR[i][j] + 0.5870*procesarG[i][j] + 0.1140*procesarB[i][j]);
                    procesarBN[i][j] = (int) (0.5870 * procesarR[i][j] + 0.2989 * procesarG[i][j] + 0.1140 * procesarB[i][j]);
                    //procesarBN[i][j]=(int)((procesarR[i][j] + procesarG[i][j] + procesarB[i][j])/3.0);

                }
            }

            // 4. Extraer contornos
            binaria = extraerContornos(procesarBN);

            // 5. La pasamos de nuevo a matriz lineal
            k = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    resultado[k++] = getRGB(new Color(binaria[i][j]));
                }
            }


            // Pasar matriz a imagen
            image.setRGB(0, 0, w, h, resultado, 0, w);

            // Guardar la imagen en un fichero BMP
            ImageIO.write(image, "JPG", new File("allRGB.jpg"));


            //Quitar: para visualizar la imagen en BN
            int[] bn = getImage(procesarBN, procesarBN, procesarBN, h, w);
            image.setRGB(0, 0, w, h, bn, 0, w);

            ImageIO.write(image, "JPG", new File("BN.jpg"));


            procesarR = aplicarGauss(procesarR);
            procesarG = aplicarGauss(procesarG);
            procesarB = aplicarGauss(procesarB);

            // Aplicamos un filtro gaussiano a cada matriz componente para suavizar la imagen
            int[] resultadoSuavizado1 = getImage(procesarR, procesarG, procesarB, h, w);
            image.setRGB(0, 0, w, h, resultadoSuavizado1, 0, w);
            ImageIO.write(image, "JPG", new File("suavizado.jpg"));

            //Fin Quitar

        } catch (IOException e) {
        }


    }

    private static int[] getImage(int[][] procesarR, int[][] procesarG, int[][] procesarB, int h, int w) {
        int k;
        int[] resultado = new int[h * w];

        k = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                resultado[k++] = getRGB(new Color(procesarR[i][j], procesarG[i][j], procesarB[i][j]));
            }
        }

        return resultado;
    }

    private static int getRGB(Color color) {
        return (color.getRed() << 16) | (color.getGreen() << 8) | color.getBlue();
    }


    private static int[][] aplicarGauss(int[][] matriz) {
        int[][] resultado = new int[h][w];
        double suma;
        double[][] gauss = {
                {0.0125, 0.025, 0.0375, 0.025, 0.0125},
                {0.025, 0.0375, 0.05, 0.0375, 0.025},
                {0.0375, 0.05, 0.0625, 0.05, 0.0375},
                {0.05, 0.0625, 0.075, 0.0625, 0.05}, // Centro
                {0.0375, 0.05, 0.0625, 0.05, 0.0375},
                {0.025, 0.0375, 0.05, 0.0375, 0.025},
                {0.0125, 0.025, 0.0375, 0.025, 0.0125},
        };

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (i == 0 || i == h - 1 || j == 0 || j == w - 1) {
                    resultado[i][j] = 0;
                } else {
                    suma = 0.0;
                    for (int k = -1; k <= 1; k++) {
                        for (int l = -1; l <= 1; l++) {
                            suma += matriz[i + k][j + l] * gauss[k + 1][l + 1];
                        }
                    }
                    resultado[i][j] = (int) suma;
                }
            }
        }
        return resultado;
    }

    private static int[][] extraerContornos(int[][] matriz) {
        int modx, mody;

        int[][] sobelx = {{-1, 0, 1}, {-2, 0, 2}, {-1, 0, 1}};
        int[][] sobely = {{-1, -2, -1}, {0, 0, 0}, {1, 2, 1}};

        int[][] modg = new int[h][w];
        double[][] theta = new double[h][w];
        int[][] thetanor = new int[h][w];
        int[][] contorno = new int[h][w];

        int umbral = 10; // Umbral mínimo del módulo del gradiente para aceptar un punto como del contorno
        int superan = 0, ncontorno = 0;
        double t;
        int signo;
        int uno, dos;


// Aplicamos máscara de convolución
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (i == 0 || i == h - 1 || j == 0 || j == w - 1) {
                    modg[i][j] = 0;
                    theta[i][j] = 0.0;
                    thetanor[i][j] = 0;
                } else {
                    modx = 0;
                    mody = 0;
                    for (int k = -1; k <= 1; k++) {
                        for (int l = -1; l <= 1; l++) {
                            modx += matriz[i + k][j + l] * sobelx[k + 1][l + 1];
                            mody += matriz[i + k][j + l] * sobely[k + 1][l + 1];
                        }
                    }
                    modx = modx / 4; //factor de compensación de la máscara
                    mody = mody / 4;

// Módulo del gradiente
                    modg[i][j] = (int) Math.sqrt(modx * modx + mody * mody);

// Dirección del gradiente
                    theta[i][j] = Math.atan2(mody, modx);
                    thetanor[i][j] = (int) (theta[i][j] * 256.0 / (2.0 * Math.PI)); // Valor normalizado 0-255
                }
            }
        }

        for (int i = 1; i < h - 1; i++) {
            for (int j = 1; j < w - 1; j++) {
                contorno[i][j] = 0;
                if (modg[i][j] >= umbral) {
                    superan++;
                    t = Math.tan(theta[i][j]);
                    if (t >= 0.0) {
                        signo = 1;
                    } else {
                        signo = -1;
                    }
                    if (Math.abs(t) < 1.0) {
// el de la derecha
                        uno = interpolar(modg[i][j + 1], modg[i - signo][j + 1], t);
// el de la izquierda
                        dos = interpolar(modg[i][j - 1], modg[i + signo][j - 1], t);
                    } else {
                        t = 1 / t;
// el de arriba
                        uno = interpolar(modg[i - 1][j], modg[i - 1][j + signo], t);
//el de abajo
                        dos = interpolar(modg[i + 1][j], modg[i + 1][j - signo], t);
                    }
                    if (modg[i][j] > uno && modg[i][j] >= dos) {
                        ncontorno++;
                        contorno[i][j] = 255;
                    }
                }
            }
        }

        System.out.println("Superan el umbra: " + superan);
        System.out.println("Pertenecen al contorno: " + ncontorno);

        return contorno;

    }

    private static int interpolar(int valor1, int valor2, double tangente) {
        return (int) (valor1 + (valor2 - valor1) * Math.abs(tangente));
    }


}
