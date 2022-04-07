import javax.swing.*;
import java.awt.*;

/**
 * The whole GameSummary. It creates the two Players and switches between them.
 */

public class GameSummary extends JFrame {

    private GameField player1     = new GameField( this, 1 );
    private GameField player2     = new GameField( this, 2 );
    private       int       clickCount  = 0;
    private       String    status      = "setShips";

    GameSummary() {
        setLayout( new CardLayout() );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add( player1 );
        add( player2 );
    }

    public void init() {
        System.out.println("Game-Status: " + getStatus());
        setMinimumSize( new Dimension( 600, 600 ) );
        setVisible( true );

        player2.setVisible( false );
        player1.setVisible( true );

        player1.setBackground( Color.GREEN );
        player2.setBackground( Color.RED );
    }

    public void changeView() {
        player1.setVisible( !player1.isVisible() );
        player2.setVisible( !player2.isVisible() );
    }

    public void startGame() {

        //Markiere eigene Schiffe zur übersicht:
        player1.getPlayground().markAllOwnShips();
        player2.getPlayground().markAllOwnShips();

        //Swap Ship-arrays, so enemy-Ships can be destroyed.
        int[][] tempShips = player1.getPlayground().getaShips();

        player1.getPlayground().setaShips( player2.getPlayground().getaShips() );
        player2.getPlayground().setaShips( tempShips );

        //Aktiviere Spielbuttons
        player1.getPlayground().activateField();
        player2.getPlayground().activateField();

        setStatus( "battle" );

        System.out.println("Game-Status: " + getStatus());
    }

    //Getter and Setter:

    public int getClickCount() {
        return clickCount;
    }

    public void setClickCount( int clickCount ) {
        this.clickCount = clickCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus( String status ) {
        this.status = status;
    }
}
