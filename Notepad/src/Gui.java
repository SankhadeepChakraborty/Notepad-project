import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui implements ActionListener {
   JFrame window;
   // text area
   JTextArea textarea;
   JScrollPane scroll;
   // bar
   JMenuBar menubar;
   // menu bar
   JMenu menufile, menuedit, menuformat, menucolour;
   // item of files menu
   JMenuItem inew, iopen, isave, isaveas, iexit;
   // format menu
   JMenuItem iwrap, ifontarial, ifontCSMS, ifontTMR, ifontsize8, ifontsize12, ifontsize16, ifontsize20, ifontsize24,
         ifontsize28;
   JMenu menufont, menufontsize;

   //colour menu item
   JMenuItem icolor1,icolor2,icolor3;

   JMenuItem iundo,iredo;

   boolean wordwrapon = false;

   FunctionFile file = new FunctionFile(this);
   Functionformat format = new Functionformat(this);
   FunctionsColor color = new FunctionsColor(this);
   FunctionEdit edit = new FunctionEdit(this);

   // constructor
    
   UndoManager um = new UndoManager();

   public Gui() {

      // calling all methods
      createwindow();
      createTextArea();
      createmenubar();
      createFileMenu();
      createformat();
      colormenu();
      createeditmenu();

      //set default font and size
      format.selectedfont="ARIAL";
      format.createfont(16);
      format.wordwrap();

      window.setVisible(true);
   }

   // define createwindow method
   public void createwindow() {
      window = new JFrame("Notepad Clone");
      window.setSize(800, 600);
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   // define the text area method
   // which help us to write our text
   public void createTextArea() {
      textarea = new JTextArea();

      //undo and redo
         textarea.getDocument().addUndoableEditListener(new UndoableEditListener() {
            public void undoableEditHappened(UndoableEditEvent e) {
                um.addEdit(e.getEdit());
            }
        });
  
      scroll = new JScrollPane(textarea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      scroll.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
      window.add(scroll);
   }

   // Create a method menubar
   // which cretes the menus for our Gui
   public void createmenubar() {
      menubar = new JMenuBar();
      window.setJMenuBar(menubar);

      // File
      menufile = new JMenu("FILE");
      menubar.add(menufile);

      // EDIT
      menuedit = new JMenu("EDIT");
      menubar.add(menuedit);

      // FORMAT
      menuformat = new JMenu("FORMAT");
      menubar.add(menuformat);

      // COLOUR
      menucolour = new JMenu("COLOUR");
      menubar.add(menucolour);
   }

   // menu items method

   public void createFileMenu() {
      // NEW
      inew = new JMenuItem("NEW");
      inew.addActionListener(this);
      inew.setActionCommand("NEW");
      menufile.add(inew);

      // OPEN
      iopen = new JMenuItem("OPEN");
      iopen.addActionListener(this);
      iopen.setActionCommand("OPEN");
      menufile.add(iopen);

      // SAVE
      isave = new JMenuItem("SAVE");
      isave.addActionListener(this);
      isave.setActionCommand("SAVE");
      menufile.add(isave);

      // SAVEAS
      isaveas = new JMenuItem("SAVEAS");
      isaveas.addActionListener(this);
      isaveas.setActionCommand("SAVEAS");
      menufile.add(isaveas);

      // EXIT
      iexit = new JMenuItem("EXIT");
      iexit.addActionListener(this);
      iexit.setActionCommand("EXIT");
      menufile.add(iexit);
   }

   // create a method to create format
   public void createformat() {
      iwrap = new JMenuItem("WORD WRAP :OFF");
      iwrap.addActionListener(this);
      iwrap.setActionCommand("WORD WRAP");
      menuformat.add(iwrap);

      menufont = new JMenu("FONT");
      menuformat.add(menufont);

      // which are shows the font item
      ifontarial = new JMenuItem("ARIAL");
      ifontarial.addActionListener(this);
      ifontarial.setActionCommand("ARIAL");
      menufont.add(ifontarial);

      ifontCSMS = new JMenuItem("CSWS");
      ifontCSMS.addActionListener(this);
      ifontCSMS.setActionCommand("CSWS");
      menufont.add(ifontCSMS);

      ifontTMR = new JMenuItem("TIMES NEW ROMAN");
      ifontTMR.addActionListener(this);
      ifontTMR.setActionCommand("TIMES NEW ROMAN");
      menufont.add(ifontTMR);

      menufontsize = new JMenu("FONT SIZE");
      menuformat.add(menufontsize);

      ifontsize8 = new JMenuItem("8");
      ifontsize8.addActionListener(this);
      ifontsize8.setActionCommand("SIZE 8");
      menufontsize.add(ifontsize8);

      ifontsize12 = new JMenuItem("12");
      ifontsize12.addActionListener(this);
      ifontsize12.setActionCommand("SIZE 12");
      menufontsize.add(ifontsize12);

      ifontsize16 = new JMenuItem("16");
      ifontsize16.addActionListener(this);
      ifontsize16.setActionCommand("SIZE 16");
      menufontsize.add(ifontsize16);

      ifontsize20 = new JMenuItem("20");
      ifontsize20.addActionListener(this);
      ifontsize20.setActionCommand("SIZE 20");
      menufontsize.add(ifontsize20);

      ifontsize24 = new JMenuItem("24");
      ifontsize24.addActionListener(this);
      ifontsize24.setActionCommand("SIZE 24");
      menufontsize.add(ifontsize24);

      ifontsize28 = new JMenuItem("28");
      ifontsize28.addActionListener(this);
      ifontsize28.setActionCommand("SIZE 28");
      menufontsize.add(ifontsize28);

   }

   public void colormenu(){
      icolor1= new JMenuItem("White");
      icolor1.addActionListener(this);
      icolor1.setActionCommand("white");
      menucolour.add(icolor1);

      icolor2= new JMenuItem("Black");
      icolor2.addActionListener(this);
      icolor2.setActionCommand("Black");
      menucolour.add(icolor2);

      icolor3= new JMenuItem("Blue");
      icolor3.addActionListener(this);
      icolor3.setActionCommand("Blue");
      menucolour.add(icolor3);


   }

   //edit menu is created

      public void createeditmenu(){
      iundo = new JMenuItem("undo");
      iundo.addActionListener(this);
      iundo .setActionCommand("undo");
      menuedit .add(iundo);

      iredo = new JMenuItem("redo");
      iredo.addActionListener(this);
      iredo .setActionCommand("redo");
      menuedit .add(iredo);


   }

   @Override
   public void actionPerformed(ActionEvent e) {
      String command = e.getActionCommand();
      switch (command) {
         case "NEW":
            file.newFile();
            break;

         case "OPEN":
            file.open();
            break;
         case "SAVE":
            file.save();
            break;
         case "SAVEAS":
            file.saveAs();
            break;

         case "EXIT":
            file.exit();
            break;

         case "WORD WRAP":
            format.wordwrap();
            break;
         case "ARIAL":
            format.setFont(command);
            break;
         case "CSWS":
         format.setFont(command);
         break;

         case "TIMES NEW ROMAN":
         format.setFont(command);
         break;

         case "SIZE 8" :
         format.createfont(8);
         break;

         case "SIZE 12" :
         format.createfont(12);
         break;

         case "SIZE 16" :
         format.createfont(16);
         break;

         case "SIZE 20" :
         format.createfont(20);
         break;

         case "SIZE 24" :
         format.createfont(24);
         break;

         case "SIZE 28" :
         format.createfont(28);
         break;

         case "White" :
         color.changeColor(command);
         break;

         case "Black" :
         color.changeColor(command);
         break;

         case "Blue" :
         color.changeColor(command);
         break;

         case "undo" :
         edit.undo();
           break;
         case "redo":
         edit.redo();
          break;
 
      }
   }

}
