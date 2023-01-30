import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class NotepadClas extends JFrame implements ActionListener {
    JTextArea textArea = new JTextArea();
    JScrollPane scrollPane = new JScrollPane(textArea);
    public NotepadClas(){
        setTitle("Note Pad for Myself");
        setBounds(500,250, 800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon notePadIcon = new ImageIcon("E:\\Java\\Projects\\NotePad\\Notepad\\src\\notepad.jpeg");
        Image notepadImage = notePadIcon.getImage();

        setIconImage(notepadImage);

        JMenuBar navbar = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        JMenu view = new JMenu("View");
        JMenu help = new JMenu("Help");
        JMenu format = new JMenu("Format");


        JMenuItem newFileItem = new JMenuItem("New");
        JMenuItem openFileItem = new JMenuItem("Open");
        JMenuItem saveFileItem = new JMenuItem("Save");
        JMenuItem printFileItem = new JMenuItem("Print");
        JMenuItem exitFileItem = new JMenuItem("Exit");

        file.add(newFileItem);
        file.add(openFileItem);
        file.add(saveFileItem);
        file.add(printFileItem);
        file.add(exitFileItem);

        JMenuItem cutEditItem = new JMenuItem("Cut");
        JMenuItem copyEditItem = new JMenuItem("Copy");
        JMenuItem pasteEditItem = new JMenuItem("Paste");
        JMenuItem selectAllEditItem = new JMenuItem("Select All");

        edit.add(cutEditItem);
        edit.add(copyEditItem);
        edit.add(pasteEditItem);
        edit.add(selectAllEditItem);

        JMenuItem wordWrap = new JMenuItem("WordWrap");
        format.add(wordWrap);

        JMenuItem about = new JMenuItem("About");
        help.add(about);

        view.addSeparator();
        JMenu viewItem = new JMenu("Zoom");
        JMenuItem zoomIn = new JMenuItem("Zoom In");
        JMenuItem zoomOut = new JMenuItem("Zoom out");


        viewItem.add(zoomIn);
        viewItem.add(zoomOut);

        view.add(viewItem);

        navbar.add(file);
        navbar.add(edit);
        navbar.add(format);
        navbar.add(view);
        navbar.add(help);

        setJMenuBar(navbar);

        textArea.setFont(new Font("San_SERIF", Font.PLAIN, 18));
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        add(scrollPane);

        about.addActionListener(this);
        newFileItem.addActionListener(this);
        openFileItem.addActionListener(this);
        saveFileItem.addActionListener(this);
        printFileItem.addActionListener(this);
        copyEditItem.addActionListener(this);
        cutEditItem.addActionListener(this);
        pasteEditItem.addActionListener(this);
        exitFileItem.addActionListener(this);
        selectAllEditItem.addActionListener(this);

        newFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
        openFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
        printFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK));
        exitFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK));
        copyEditItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
        cutEditItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, KeyEvent.CTRL_DOWN_MASK));
        pasteEditItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK));
        selectAllEditItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK));
        about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_DOWN_MASK));
        saveFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("New")){
            textArea.setText(null);
        }
        else if(e.getActionCommand().equals("Open")){
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter textFilter = new FileNameExtensionFilter("Only Text Files(.txt)", "txt");
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(textFilter);

            int action = fileChooser.showSaveDialog(null);
            if (action != JFileChooser.APPROVE_OPTION) {
                return;
            } else {
                String fileName = fileChooser.getSelectedFile().getAbsolutePath().toString();
                if (!fileName.contains(".txt"))
                    fileName = fileName + ".txt";

                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                    textArea.write(writer);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        else if(e.getActionCommand().equals("Save")){
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter textFilter = new FileNameExtensionFilter("Only Text Files(.txt)", "txt");
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(textFilter);
            int action = fileChooser.showSaveDialog(null);
            if(action != JFileChooser.APPROVE_OPTION)
                return;
            else{
                String filename = fileChooser.getSelectedFile().getAbsolutePath().toString();
                if(!filename.contains(".txt")){
                    filename += ".txt";

                    try{
                        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
                        textArea.write(writer);
                    }catch (Exception ex)
                    {
                        ex.printStackTrace();
                    }

                }
            }
        }
        else if(e.getActionCommand().equals("Print")){
            try{
                textArea.print();
            }catch (Exception sdsad){
                sdsad.printStackTrace();
            }
        }
        else if(e.getActionCommand().equals("Exit")){
            System.exit(0);
        }
        else if(e.getActionCommand().equals("Cut")){
            textArea.copy();
        }
        else if(e.getActionCommand().equals("Copy")){
            textArea.copy();
        }
        else if(e.getActionCommand().equals("Select All")){
            textArea.selectAll();
        }
        else if(e.getActionCommand().equals("About")){
            new AboutClass().setVisible(true);
        }
        else if(e.getActionCommand().equals("Paste")){
            textArea.paste();
        }
        else if (e.getActionCommand().equals("WordWrap")){


        }
    }

    private void wordWrapFunction(){

        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
    }
    public static void main(String[] args) throws Exception{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        new NotepadClas().setVisible(true);
    }
}
