import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class FunctionFile {
    Gui gui;
    String filename;
    String fileaddress;

    FunctionFile(Gui gui) {
        this.gui = gui;

    }

    // function to create a new file
    // whenever some one click on the new items
    public void newFile() {
        // Erase the current text
        gui.textarea.setText("");
        gui.window.setTitle("NEW");// create the default new name of new file

    }

    // function to open a existing file
    public void open() {
        // to display dialog
        FileDialog fd = new FileDialog(gui.window, "OPEN", FileDialog.LOAD);
        fd.setVisible(true);

        // logic to open any file
        if (fd.getFile() != null) {
            filename = fd.getFile();
            fileaddress = fd.getDirectory();
            // System.out.println(filename + fileaddress);
            gui.window.setTitle(filename);
        }
        // display the content of the file
        // use buffer reader

        try {
            // you need to read the address of the file
            BufferedReader br = new BufferedReader(new FileReader(fileaddress + filename));
            gui.textarea.setText("");
            String line;
            while ((line = br.readLine()) != null) {
                gui.textarea.append(line + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // function to save
   // function to save
   public void save() {
    if (filename == null) {
        saveAs();
    } else {
        try {
            FileWriter fw = new FileWriter(fileaddress + filename);
            fw.write(gui.textarea.getText());
            gui.window.setTitle(filename);
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// function to save as
public void saveAs() {
    FileDialog fd = new FileDialog(gui.window, "Save", FileDialog.SAVE);
    fd.setVisible(true);

    if (fd.getFile() != null) {
        filename = fd.getFile();
        fileaddress = fd.getDirectory();
        gui.window.setTitle(filename);
    }

    try {
        FileWriter fw = new FileWriter(fileaddress + filename);
        fw.write(gui.textarea.getText());
        fw.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    public void exit(){
        System.exit(0);
    }
}
