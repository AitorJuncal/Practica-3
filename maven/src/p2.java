import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;

public class p2 extends JFrame {

	private JPanel contentPane;
	private JTextField idAlarma;
	private GestionAlarmas gestion = new GestionAlarmas();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					p2 frame = new p2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public p2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		idAlarma = new JTextField();
		idAlarma.setColumns(10);
		
		JSpinner horaAlarma = new JSpinner();
		horaAlarma.setModel(new SpinnerDateModel(new Date(1618264800000L), new Date(1618264800000L), new Date(1618351199000L), Calendar.DAY_OF_YEAR));
		
		JLabel lblNewLabel = new JLabel("hora");
		
		JLabel lblNewLabel_1 = new JLabel("id Alarma");
		
		JLabel lblNewLabel_2 = new JLabel("Alarmas activas");
		
		JTextPane panelActivas = new JTextPane();
		
		JLabel lblNewLabel_3 = new JLabel("Alarmas desactivadas");
		
		JTextPane panelDesactivadas = new JTextPane();
		
		JButton nuevaAlarma = new JButton("Nueva Alarma");
		nuevaAlarma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		nuevaAlarma.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int id = Integer.parseInt(idAlarma.getText());
				Date hora = (Date) horaAlarma.getValue();
				gestion.anhadeAlarma(new Alarma(id, hora));
			}
		});
		
		JButton apagarAlarma = new JButton("Apagar");
		apagarAlarma.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int id = Integer.parseInt(idAlarma.getText());
				Alarma a = gestion.buscaAlarma(id);
				gestion.desactivaAlarma(a);
				JLabel comp = new JLabel("id = +", id);
				panelDesactivadas.add(comp);
				panelActivas.remove(comp);
			}
		});
		
		JButton alarmaOn = new JButton("ON");
		alarmaOn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int id = Integer.parseInt(idAlarma.getText());
				Alarma a = gestion.buscaAlarma(id);
				gestion.ActivaAlarma(a);
				JLabel comp = new JLabel("id = +", id);
				panelActivas.add(comp);
				panelDesactivadas.remove(comp);
			}
		});
		alarmaOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton alarmaOff = new JButton("OFF");
		alarmaOff.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int id = Integer.parseInt(idAlarma.getText());
				Alarma a = gestion.buscaAlarma(id);
				gestion.desactivaAlarma(a);
				JLabel comp = new JLabel("id = +", id);
				panelDesactivadas.add(comp);
				panelActivas.remove(comp);
			}
		});
		alarmaOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton eliminarAlarma = new JButton("Eliminar");
		eliminarAlarma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		eliminarAlarma.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int id = Integer.parseInt(idAlarma.getText());
				Alarma a = gestion.buscaAlarma(id);
				gestion.eliminaAlarma(a);
				
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(horaAlarma, 0, 0, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(idAlarma, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(50)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(apagarAlarma)
								.addComponent(nuevaAlarma))))
					.addPreferredGap(ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(eliminarAlarma, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelActivas, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(panelDesactivadas, Alignment.LEADING)
							.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
								.addComponent(alarmaOff)
								.addGap(18)
								.addComponent(alarmaOn))))
					.addGap(45))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(260, Short.MAX_VALUE)
					.addComponent(lblNewLabel_2)
					.addGap(94))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(13)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(26)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(idAlarma, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel)
										.addComponent(horaAlarma, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(nuevaAlarma)
									.addGap(18)
									.addComponent(apagarAlarma))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(19)
									.addComponent(panelActivas, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblNewLabel_3)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(panelDesactivadas, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)))
							.addGap(35)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(alarmaOff)
								.addComponent(alarmaOn))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(eliminarAlarma))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_2)))
					.addContainerGap(37, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
