package net.minecraft.server;

import com.mojang.util.QueueLogAppender;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.DedicatedServer;
import net.minecraft.server.class_kt;
import net.minecraft.server.class_ku;
import net.minecraft.server.ICommandListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_ks extends JComponent {
   private static final Font a = new Font("Monospaced", 0, 12);
   private static final Logger b = LogManager.getLogger();
   private DedicatedServer c;

   public static void a(final DedicatedServer var0) {
      try {
         UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      } catch (Exception var3) {
         ;
      }

      class_ks var1 = new class_ks(var0);
      JFrame var2 = new JFrame("Minecraft server");
      var2.add(var1);
      var2.pack();
      var2.setLocationRelativeTo((Component)null);
      var2.setVisible(true);
      var2.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent var1) {
            var0.w();

            while(!var0.ao()) {
               try {
                  Thread.sleep(100L);
               } catch (InterruptedException var3) {
                  var3.printStackTrace();
               }
            }

            System.exit(0);
         }
      });
   }

   public class_ks(DedicatedServer var1) {
      this.c = var1;
      this.setPreferredSize(new Dimension(854, 480));
      this.setLayout(new BorderLayout());

      try {
         this.add(this.c(), "Center");
         this.add(this.a(), "West");
      } catch (Exception var3) {
         b.error((String)"Couldn\'t build server GUI", (Throwable)var3);
      }

   }

   private JComponent a() throws Exception {
      JPanel var1 = new JPanel(new BorderLayout());
      var1.add(new class_ku(this.c), "North");
      var1.add(this.b(), "Center");
      var1.setBorder(new TitledBorder(new EtchedBorder(), "Stats"));
      return var1;
   }

   private JComponent b() throws Exception {
      class_kt var1 = new class_kt(this.c);
      JScrollPane var2 = new JScrollPane(var1, 22, 30);
      var2.setBorder(new TitledBorder(new EtchedBorder(), "Players"));
      return var2;
   }

   private JComponent c() throws Exception {
      JPanel var1 = new JPanel(new BorderLayout());
      final JTextArea var2 = new JTextArea();
      final JScrollPane var3 = new JScrollPane(var2, 22, 30);
      var2.setEditable(false);
      var2.setFont(a);
      final JTextField var4 = new JTextField();
      var4.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent var1) {
            String var2 = var4.getText().trim();
            if(!var2.isEmpty()) {
               class_ks.this.c.a(var2, (ICommandListener)MinecraftServer.getServer());
            }

            var4.setText("");
         }
      });
      var2.addFocusListener(new FocusAdapter() {
         public void focusGained(FocusEvent var1) {
         }
      });
      var1.add(var3, "Center");
      var1.add(var4, "South");
      var1.setBorder(new TitledBorder(new EtchedBorder(), "Log and chat"));
      Thread var5 = new Thread(new Runnable() {
         public void run() {
            String var1;
            while((var1 = QueueLogAppender.getNextLogEvent("ServerGuiConsole")) != null) {
               class_ks.this.a(var2, var3, var1);
            }

         }
      });
      var5.setDaemon(true);
      var5.start();
      return var1;
   }

   public void a(final JTextArea var1, final JScrollPane var2, final String var3) {
      if(!SwingUtilities.isEventDispatchThread()) {
         SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               class_ks.this.a(var1, var2, var3);
            }
         });
      } else {
         Document var4 = var1.getDocument();
         JScrollBar var5 = var2.getVerticalScrollBar();
         boolean var6 = false;
         if(var2.getViewport().getView() == var1) {
            var6 = (double)var5.getValue() + var5.getSize().getHeight() + (double)(a.getSize() * 4) > (double)var5.getMaximum();
         }

         try {
            var4.insertString(var4.getLength(), var3, (AttributeSet)null);
         } catch (BadLocationException var8) {
            ;
         }

         if(var6) {
            var5.setValue(Integer.MAX_VALUE);
         }

      }
   }
}
