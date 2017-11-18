package codes;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Component;
import javax.swing.DropMode;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridLayout;
import java.awt.TextField;

import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.ScrollPaneConstants;

public class lrcShowMain extends JFrame implements Runnable{
	JScrollPane jsp;
	int i = 0;
	static final boolean f=false;
	static final boolean t=true;
	currentMills gettime = new currentMills();
	static LyricShow showlrc = new LyricShow();
	static LyricShow showlrc2 = new LyricShow();
	static LyricShow showlrc3 = new LyricShow();
	static currentMills cm = new currentMills();
	static String fileName="";
	JScrollPane scrollPane = new JScrollPane();
	LyReadIn lr = new LyReadIn();
	
	JLabel lrcShow = new JLabel();
	JButton btnStart = new JButton("\u5F00\u59CB");
	JButton btnStop = new JButton("\u505C\u6B62");
	JList list = new JList();
	
	boolean isGoingOn=false;
	JTextField textField;
	public lrcShowMain() {
		setAlwaysOnTop(true);
		
		setUndecorated(true);
		setOpacity(0.8f);
		//new JScrollPane(list,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//JScrollPane scrlpane=new JScrollPane(list);
		//add(scrlpane);
		//scrlpane.setSize(10,10);
		getContentPane().setBackground(Color.BLACK);
		setTitle("\u6B4C\u8BCD\u663E\u793A v1.0");
		setIconImage(Toolkit.getDefaultToolkit().getImage(lrcShowMain.class.getResource("/javax/swing/plaf/metal/icons/ocean/upFolder.gif")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(959,548);
		btnStart.setBackground(Color.WHITE);
		btnStart.setToolTipText("\u5F00\u59CB\u64AD\u653E\u4F60\u7684\u6B4C\u8BCD\u6587\u4EF6");
		btnStart.setEnabled(false);
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isGoingOn=true;
			}
		});

		//new JScrollPane(list);
		JButton openfile = new JButton("\u6253\u5F00");
		openfile.setBackground(Color.WHITE);
		openfile.setToolTipText("\u6253\u5F00\u4E00\u4E2A\u65B0\u6587\u4EF6");
		JFileChooser jc = new JFileChooser();
		openfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jc.showOpenDialog(openfile);
				if(!jc.getSelectedFile().exists()||!jc.getSelectedFile().isFile()
						||jc.getSelectedFile().toString()==null){
					System.out.println("ERROR!");
				}else{
					try {
						cm.reset();
						fileName=null;
						isGoingOn=false;
						fileName=jc.getSelectedFile().toString();
						showlrc.Load(fileName,true);
						showlrc2.Load(fileName,false);
						showlrc3.Load(fileName,false);
						btnStart.setEnabled(true);
						btnStop.setEnabled(true);
						list.setModel(new AbstractListModel() {
							String[] values = lr.lrcsOut(fileName);
							public int getSize() {
								return values.length;
							}
							public Object getElementAt(int index) {
								return values[index];
							}
						});
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		btnStop.setBackground(Color.WHITE);
		btnStop.setToolTipText("\u505C\u6B62\u64AD\u653E\u4F60\u7684\u6B4C\u8BCD(Bugs#Issue1)");
		list.setBackground(Color.BLACK);
		scrollPane.setViewportView(list);
		
		btnStop.setEnabled(false);
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cm.reset();
				currentMills.m=0;
				currentMills.s=0;
				btnStart.setEnabled(f);
				btnStart.setEnabled(f);
				isGoingOn=false;
			}
		});
		
		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setToolTipText("\u65F6\u95F4");
		textField.setText("00.00");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		
		JButton btnBwd = new JButton("<<");
		btnBwd.setBackground(Color.WHITE);
		btnBwd.setToolTipText("\u5FEB\u9000");
		btnBwd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gettime.backward(3);
			}
		});
		
		JButton btnFwd = new JButton(">>");
		btnFwd.setBackground(Color.WHITE);
		btnFwd.setToolTipText("\u5FEB\u8FDB");
		btnFwd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gettime.forward(3);
			}
		});
		lrcShow.setForeground(Color.WHITE);
		
		lrcShow.setText("WEL"+"\n"+"COME");
		lrcShow.setFont(new Font("ºÚÌå", Font.BOLD, 98));
		lrcShow.setHorizontalAlignment(SwingConstants.CENTER);
		list.setForeground(Color.WHITE);
		list.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.BOLD, 17));
		list.setLayoutOrientation(0);
		list.setBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), "\u6B4C\u8BCD", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(204, 255, 255)));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"\u6B22\u8FCE\u4F7F\u7528\uFF01", "\u5982\u679C", "\u60F3\u8981", "\u5728\u8FD9\u91CC", "\u663E\u793A\u6B4C\u8BCD", "\u8BF7\u6253\u5F00", "\u4E00\u4E2A", "\u6B4C\u8BCD", "\u6587\u4EF6"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setSelectedIndex(0);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lrcShow, GroupLayout.PREFERRED_SIZE, 773, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(openfile, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(btnStart, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(btnStop, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
							.addGap(458)
							.addComponent(btnBwd)
							.addGap(6)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(btnFwd))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lrcShow, GroupLayout.PREFERRED_SIZE, 438, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(22)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 409, GroupLayout.PREFERRED_SIZE)))
					.addGap(15)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(openfile)
						.addComponent(btnStart)
						.addComponent(btnStop)
						.addComponent(btnBwd)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnFwd)))
		);
		getContentPane().setLayout(groupLayout);
	}
	
	
	public void run(){
		try {
			while(true){
				
				
				
				
				
				
				Thread.sleep(10);
				//System.out.println("WAITING FOR "+isGoingOn+"  ...");
				if(isGoingOn){
					
					
				
					
					lrcShow.setText(showlrc.getReturns(fileName, 0,true));
					list.setSelectedIndex(cm.getlrcNum());
					textField.setText(cm.m+":"+cm.s);
					System.out.println(i++);
				}
				if(lrcShow.getText().length()>19&&lrcShow.getText().length()<25){
					lrcShow.setFont(new Font("Î¢ÈíÑÅºÚ",21,80));
				}else if(lrcShow.getText().length()<=19){
					lrcShow.setFont(new Font("Î¢ÈíÑÅºÚ",25,70));
				}else if(lrcShow.getText().length()>25){
					lrcShow.setFont(new Font("ºÚÌå",21,60));
				}
				//System.out.println("playinf");
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
		//showlrc.Load(fileName,true);
		//showlrc2.Load(fileName,false);
		new Thread(new lrcShowMain()).start();
		
	}
}
