import javax.swing.*;
import java.awt.*;

public class PausePanel extends JPanel {

    private JButton resumeP1 = new JButton( "Resume to Player 1" );
    private JButton resumeP2 = new JButton( "Resume to Player 2" );
    private GameSummary gameSummary;

    PausePanel(GameSummary gameSummary) {
        setMinimumSize( new Dimension(600,600) );
        setVisible( true );

        this.gameSummary = gameSummary;

        //Settings p1:
        resumeP1.addActionListener( new Listener(gameSummary) );
        resumeP1.setActionCommand( "resP1" );

        resumeP2.addActionListener( new Listener(gameSummary) );
        resumeP2.setActionCommand( "resP2" );

        add(resumeP1);
        add(resumeP2);
    }

}