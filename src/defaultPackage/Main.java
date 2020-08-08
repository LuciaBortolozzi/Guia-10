package defaultPackage;

import controller.FrameMenuCtrl;
import view.FrameMenu;

public class Main {

    public static void main(String[] args){
        FrameMenuCtrl frameMenuCtrl = new FrameMenuCtrl();
        new FrameMenu(frameMenuCtrl);
    }
}
