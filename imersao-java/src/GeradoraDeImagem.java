import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeImagem {

    public void criar(InputStream inputStream, String nomeArquivo) throws Exception {

        //leitura de imagem
        //InputStream inputStream = new FileInputStream("entrada/filme.jpg")
        //InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg").openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        //cria nova imagem em memoria com transparencia
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;

        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        //copiar a imagem original para nova imagem
        Graphics2D graphics = (Graphics2D)novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);
        
        //configurar fonte
        var fonte = new Font(Font.SERIF, Font.ITALIC, 70);
        graphics.setColor(Color.RED);
        graphics.setFont(fonte);

        //graphics.getFontMetrics(largura/ 2 - (novaAltura / 2));

                
        //escrever uma frase nova imagem 
        graphics.drawString("**EU CHEGO LÁ**", 100, novaAltura-100);
        
        //escrever nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));
    
    }
    }
