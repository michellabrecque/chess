package support;

import com.objogate.wl.swing.AWTEventQueueProber;
import com.objogate.wl.swing.driver.ComponentDriver;
import com.objogate.wl.swing.driver.JButtonDriver;
import com.objogate.wl.swing.driver.JFrameDriver;
import com.objogate.wl.swing.driver.JLabelDriver;
import com.objogate.wl.swing.gesture.GesturePerformer;
import gui.renderers.PawnRenderer;
import gui.renderers.PieceRenderer;
import gui.renderers.QueenRenderer;

import javax.swing.*;

import static gui.GameFrame.TITLE;
import static org.hamcrest.CoreMatchers.equalTo;

public class GameDriver extends JFrameDriver {

    @SuppressWarnings("unchecked")
    public GameDriver() {
        super(new GesturePerformer(), new AWTEventQueueProber(), named( TITLE ), showingOnScreen());
        ((AWTEventQueueProber) prober()).setTimeout( 100 );
    }
    public JLabelDriver label(String name) {
        return new JLabelDriver(this, ComponentDriver.named( name ));
    }
    public JButtonDriver button(String name) {
        return new JButtonDriver(this, JButton.class, ComponentDriver.named( name ));
    }

    public JButtonDriver cell(String name) {
        return button( name );
    }

    public void hasNothingOn(String cell) {
        button( cell ).hasText( equalTo( "" ) );
    }

    public void has(PieceRenderer renderer, String location) {
        button( location ).hasText( equalTo( renderer.toString() ));
    }

    public static String on(String position) {
        return position;
    }

    public static PieceRenderer pawn() {
        return new PawnRenderer(null);
    }

    public static PieceRenderer queen() {
        return new QueenRenderer(null);
    }

}