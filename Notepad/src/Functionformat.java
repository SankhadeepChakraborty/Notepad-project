import java.awt.Font;
public class Functionformat {
    Gui gui;
    private boolean wordwrapon;
   Font arial, comicsans,timesnewroman;
   String selectedfont;
   
    public Functionformat(Gui gui){
        this.gui =gui;
       
    }
        //word wrap method
     public void wordwrap(){
        if (gui.wordwrapon == false){
            gui.wordwrapon = true;
            gui.textarea.setLineWrap(true);
            gui.textarea.setWrapStyleWord(true);
            gui.iwrap.setText("WORD WRAP : ON");
        }else{
            gui.wordwrapon=false;
            gui.textarea.setLineWrap(false);
            gui.textarea.setWrapStyleWord(false);
            gui.iwrap.setText("WORD WRAP : OFF");

        }

     }

     //font type
     public void createfont(int fontSize){
       arial = new Font("ARIAL",Font.PLAIN,fontSize);
        comicsans = new Font("COMIC SANS WS",Font.PLAIN,fontSize);
        timesnewroman = new Font("TIMES NEW ROMAN",Font.PLAIN,fontSize);
        setFont(selectedfont);
     }

     // set font method
     public void setFont(String font){

        selectedfont= font;
        switch(selectedfont){
            case "ARIAL":
            gui.textarea.setFont(arial);
            break;
            case "CSWS":
            gui.textarea.setFont(comicsans);
            break;

            case "TIMES NEW ROMAN":
            gui.textarea.setFont(timesnewroman);
            break;

        }

     }
    
}
