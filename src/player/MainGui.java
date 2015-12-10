package mediaplayer;

import java.awt.Toolkit;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author Kaspar
 * @version 1.0
 * @since 
 */
public class MainGui extends javax.swing.JDialog {

    MainClass mainC = new MainClass();

    /**
     * Muutuja count näitab, kas parajasti lugu on loop'is või ei ole
     */
    public static int count;

    int xMouse;
    int yMouse;

    int width = (Toolkit.getDefaultToolkit().getScreenSize().width / 2) - 185;
    int height = Toolkit.getDefaultToolkit().getScreenSize().height - 180;

    /**
     *
     * @param parent
     * @param modal
     */
    public MainGui(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    /**
     * GUI ning Netbeansi poolt automaatselt genereeritud kood
     */
    @SuppressWarnings("unchecked")
                              
    private void initComponents() {

        Play = new javax.swing.JLabel();
        Pause = new javax.swing.JLabel();
        Stop = new javax.swing.JLabel();
        Loop = new javax.swing.JLabel();
        SelectFile = new javax.swing.JLabel();
        Close = new javax.swing.JLabel();
        Display = new javax.swing.JLabel();
        LoopCount = new javax.swing.JLabel();
        Mute = new javax.swing.JLabel();
        Slider = new javax.swing.JSlider();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Play.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Play.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PlayMouseReleased(evt);
            }
        });
        getContentPane().add(Play, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 94, 30, 40));

        Pause.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Pause.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PauseMouseReleased(evt);
            }
        });
        getContentPane().add(Pause, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 94, 30, 40));

        Stop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Stop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                StopMouseReleased(evt);
            }
        });
        getContentPane().add(Stop, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 104, 30, 30));

        Loop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Loop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                LoopMouseReleased(evt);
            }
        });
        getContentPane().add(Loop, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 104, 30, 30));

        SelectFile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SelectFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                SelectFileMouseReleased(evt);
            }
        });
        getContentPane().add(SelectFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 94, 20, 40));

        Close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                CloseMouseReleased(evt);
            }
        });
        getContentPane().add(Close, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 4, 20, 20));

        Display.setFont(new java.awt.Font("Century Gothic", 0, 24)); 
        Display.setForeground(new java.awt.Color(204, 204, 204));
        Display.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Display, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 220, 70));

        LoopCount.setFont(new java.awt.Font("OCR A Extended", 0, 12)); 
        LoopCount.setForeground(new java.awt.Color(204, 204, 204));
        getContentPane().add(LoopCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 174, 70, 30));

        Mute.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(Mute, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 104, 20, 20));

        Slider.setPaintTicks(true);
        getContentPane().add(Slider, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 106, 60, 20));

        Background.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kaspar\\Desktop\\Background.png"));
        Background.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Background.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                BackgroundMouseDragged(evt);
            }
        });
        Background.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BackgroundMousePressed(evt);
            }
        });
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }                       
//Automaatselt genereeritud koodi lõpp


    private void StopMouseReleased(java.awt.event.MouseEvent evt) {                                   
        mainC.Stop();
    }                                  

    private void BackgroundMouseDragged(java.awt.event.MouseEvent evt) {                                        
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xMouse, y - yMouse);
    }                                       

    private void BackgroundMousePressed(java.awt.event.MouseEvent evt) {                                        
        xMouse = evt.getX();
        yMouse = evt.getY();
    }                                       

    private void PlayMouseReleased(java.awt.event.MouseEvent evt) {                                   
        mainC.Resume();
    }                                  

    private void PauseMouseReleased(java.awt.event.MouseEvent evt) {                                    
        mainC.Pause();
    }                                   

    private void SelectFileMouseReleased(java.awt.event.MouseEvent evt) {                                         
//Filtreeritakse välja ainult .mp3 faililaiendiga failid        
        FileFilter filter = new FileNameExtensionFilter("MP3 Files", "mp3", "mpeg3");
        JFileChooser chooser = new JFileChooser("Desktop");
        chooser.addChoosableFileFilter(filter);

        int returnVal = chooser.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
//Stop meetodit kasutades peatab kõik eelnevad lood, et ei tekiks lõpmatut loopi            
            mainC.Stop();
            File myFile = chooser.getSelectedFile();
            String song = myFile + "";
//Võtab faili nime ning kuvab ekraanile            
            String name = chooser.getSelectedFile().getName();
            Display.setText(name);

            mainC.Play(song);

        }
    }                                        

    private void LoopMouseReleased(java.awt.event.MouseEvent evt) {                                   
        switch (count) {
            case 0:
                count = 1;
                LoopCount.setText("Loop on");
                break;
            case 1:
                count = 0;
                LoopCount.setText("Loop off");
                break;
        }
    }                                  

    private void CloseMouseReleased(java.awt.event.MouseEvent evt) {                                    
        dispose();
    }                                   

    /**
     * @param args
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainGui dialog = new MainGui(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

                       
    private javax.swing.JLabel Background;
    private javax.swing.JLabel Close;
    public static javax.swing.JLabel Display;
    private javax.swing.JLabel Loop;
    private javax.swing.JLabel LoopCount;
    private javax.swing.JLabel Mute;
    private javax.swing.JLabel Pause;
    private javax.swing.JLabel Play;
    private javax.swing.JLabel SelectFile;
    private javax.swing.JSlider Slider;
    private javax.swing.JLabel Stop;
                      
}
