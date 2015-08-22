package net.minecraft.server;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JComponent;
import javax.swing.Timer;

public class class_kz extends JComponent {
	private static final DecimalFormat a = new DecimalFormat("########0.000");
	private int[] b = new int[256];
	private int c;
	private String[] d = new String[11];
	private final MinecraftServer e;

	public class_kz(MinecraftServer var1) {
		e = var1;
		setPreferredSize(new Dimension(456, 246));
		setMinimumSize(new Dimension(456, 246));
		setMaximumSize(new Dimension(456, 246));
		(new Timer(500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent var1) {
				class_kz.this.a();
			}
		})).start();
		setBackground(Color.BLACK);
	}

	private void a() {
		long var1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		System.gc();
		d[0] = "Memory use: " + (var1 / 1024L / 1024L) + " mb (" + ((Runtime.getRuntime().freeMemory() * 100L) / Runtime.getRuntime().maxMemory()) + "% free)";
		d[1] = "Avg tick: " + a.format(this.a(e.h) * 1.0E-6D) + " ms";
		this.repaint();
	}

	private double a(long[] var1) {
		long var2 = 0L;

		for (int var4 = 0; var4 < var1.length; ++var4) {
			var2 += var1[var4];
		}

		return (double) var2 / (double) var1.length;
	}

	@Override
	public void paint(Graphics var1) {
		var1.setColor(new Color(16777215));
		var1.fillRect(0, 0, 456, 246);

		int var2;
		for (var2 = 0; var2 < 256; ++var2) {
			int var3 = b[(var2 + c) & 255];
			var1.setColor(new Color((var3 + 28) << 16));
			var1.fillRect(var2, 100 - var3, 1, var3);
		}

		var1.setColor(Color.BLACK);

		for (var2 = 0; var2 < d.length; ++var2) {
			String var4 = d[var2];
			if (var4 != null) {
				var1.drawString(var4, 32, 116 + (var2 * 16));
			}
		}

	}
}
