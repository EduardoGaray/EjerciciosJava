import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;

public class Pokemon {
    //creating a constructor of file class and parsing an XML file
    static LinkedHashMap <String,Element> map = new LinkedHashMap<>();
    static File file = new File("./Pokemon.xml");
    static int id = 1;
    public static void main(String argv[]) {
        try {
            BufferedImage pic = ImageIO.read(new File("./pokemon/charmander.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JFrame f=new JFrame("Poquedex");
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        f.setSize(400,400);
        f.setResizable(false);
        f.setLayout(null);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JButton b=new JButton("Siguiente Pokémon");
        b.setBackground(Color.WHITE);
        b.setBorder(border);
        JButton b2=new JButton("Anterior Pokémon");
        b.setBounds(20,0,160,30);
        b2.setBounds(190,0,160,30);
        b2.setBackground(Color.WHITE);
        b2.setBorder(border);
        JLabel pic = new JLabel();
        pic.setLayout(null);
        pic.setBounds(0,30,f.getWidth()/2,170);
        pic.setBorder(border);

        JTextArea stat = new JTextArea();
        stat.setEditable(false);
        stat.setBackground(Color.WHITE);
        stat.setLayout(null);
        stat.setBounds(f.getWidth()/2,30,f.getWidth()/2,170);
        stat.setForeground(Color.black);
        stat.setBorder(border);
        JTextArea desctxt = new JTextArea();
        desctxt.setBounds(0,f.getHeight()/2,f.getWidth(),f.getHeight()/2-30);
        desctxt.setForeground(Color.black);
        desctxt.setEditable(false);
        desctxt.setBackground(Color.WHITE);
        desctxt.setBorder(border);
        f.add(b);
        f.add(b2);
        f.add(pic);
        f.add(stat);
        f.add(desctxt);
        f.setVisible(true);
        try
        {
//an instance of factory that gives a document builder
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//an instance of builder to parse the specified xml file
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("Pokemon");
            Element eElement = null;
// nodeList is not iterable, so we are using for loop
            for (int itr = 0; itr < nodeList.getLength(); itr++) {
                Node node = nodeList.item(itr);
                if (node.getNodeType() == Node.ELEMENT_NODE)
                {
                    eElement = (Element) node;
                      map.put(eElement.getElementsByTagName("id").item(0).getTextContent(), (Element) node);
                }
            }
            stat.setText("");
            desctxt.setText("");
            stat.setText(stat.getText() + "\n ID: " + map.get("1").getElementsByTagName("id").item(0).getTextContent());
            stat.setText(stat.getText() + "\n NOMBRE: " + map.get("1").getElementsByTagName("name").item(0).getTextContent());
            stat.setText(stat.getText() + "\n APODO: " + map.get("1").getElementsByTagName("nickname").item(0).getTextContent());
            stat.setText(stat.getText() + "\n ALTURA: " + map.get("1").getElementsByTagName("height").item(0).getTextContent());
            stat.setText(stat.getText() + "\n PESO: " + map.get("1").getElementsByTagName("weight").item(0).getTextContent());
            desctxt.setText(desctxt.getText() + " \n" + map.get("1").getElementsByTagName("desc").item(0).getTextContent());
            pic.setIcon(new ImageIcon(new ImageIcon("./pokemon/"+map.get("1").getElementsByTagName("name").item(0).getTextContent()+".png").getImage().getScaledInstance(pic.getWidth(),pic.getHeight(), Image.SCALE_DEFAULT)));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (id < map.size()){
                    id += 1;
                    }

                String strid =Integer.toString(id);
                stat.setText("");
                desctxt.setText("");
                stat.setText(stat.getText() + "\n ID: " + map.get(strid).getElementsByTagName("id").item(0).getTextContent());
                stat.setText(stat.getText() + "\n NOMBRE: " + map.get(strid).getElementsByTagName("name").item(0).getTextContent());
                stat.setText(stat.getText() + "\n APODO: " + map.get(strid).getElementsByTagName("nickname").item(0).getTextContent());
                stat.setText(stat.getText() + "\n ALTURA: " + map.get(strid).getElementsByTagName("height").item(0).getTextContent());
                stat.setText(stat.getText() + "\n PESO: " + map.get(strid).getElementsByTagName("weight").item(0).getTextContent());
                desctxt.setText(desctxt.getText() + " \n" + map.get(strid).getElementsByTagName("desc").item(0).getTextContent());
                pic.setIcon(new ImageIcon(new ImageIcon("./pokemon/"+map.get(strid).getElementsByTagName("name").item(0).getTextContent()+".png").getImage().getScaledInstance(pic.getWidth(),pic.getHeight(), Image.SCALE_DEFAULT)));
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (id > 1){
                    id -= 1;
                }
                String strid =Integer.toString(id);
                stat.setText("");
                desctxt.setText("");
                stat.setText(stat.getText() + "\n ID: " + map.get(strid).getElementsByTagName("id").item(0).getTextContent());
                stat.setText(stat.getText() + "\n NOMBRE: " + map.get(strid).getElementsByTagName("name").item(0).getTextContent());
                stat.setText(stat.getText() + "\n APODO: " + map.get(strid).getElementsByTagName("nickname").item(0).getTextContent());
                stat.setText(stat.getText() + "\n ALTURA: " + map.get(strid).getElementsByTagName("height").item(0).getTextContent());
                stat.setText(stat.getText() + "\n PESO: " + map.get(strid).getElementsByTagName("weight").item(0).getTextContent());
                desctxt.setText(desctxt.getText() + " \n" + map.get(strid).getElementsByTagName("desc").item(0).getTextContent());
                pic.setIcon(new ImageIcon(new ImageIcon("./pokemon/"+map.get(strid).getElementsByTagName("name").item(0).getTextContent()+".png").getImage().getScaledInstance(pic.getWidth(),pic.getHeight(), Image.SCALE_DEFAULT)));
            }
        });
    }
}
