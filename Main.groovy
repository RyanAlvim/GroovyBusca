import groovy.swing.SwingBuilder
import javax.swing.JOptionPane

def busca = new BuscarIP();
def result = new Results();
new SwingBuilder().edt {
  frame(title: 'Checker IP', size: [300, 300], locationRelativeTo: null, show: true) {
    gridLayout(cols: 1, rows: 2)
    button('Buscar IP', actionPerformed: {busca.Buscar()})
    button('Credits', actionPerformed: {JOptionPane.showMessageDialog(null, "GλrkeyLonely#6714")})
    button('Última Result', actionPerformed:{result.Read()})
    button('Exit',actionPerformed: {System.exit(0)})
    }
  }