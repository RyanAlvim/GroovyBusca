import java.io.File
import java.io.FileReader;
import javax.swing.JOptionPane
import java.io.File;

class Results{
    def Read(){
    File lerarq = new File("result.txt") 
      JOptionPane.showMessageDialog(null,lerarq.text) 
    }
}