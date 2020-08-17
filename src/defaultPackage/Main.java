package defaultPackage;

import controller.CtrlFrameMenu;
import view.FrameMenu;

public class Main {

    public static void main(String[] args){
        CtrlFrameMenu ctrlFrameMenu = new CtrlFrameMenu();
        new FrameMenu(ctrlFrameMenu);
    }
}
