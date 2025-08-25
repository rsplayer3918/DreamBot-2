package template.state;

import GUI.Window;
import common.state.BaseState;

public class TemplateState extends BaseState {

        public TemplateState() {
                Window window = new Window(this);
                init(window, window.getRootPanel(), Window.W, Window.H, Window.TITLE);
        }
}
