package unused;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.Canvas;
import javax.swing.JSlider;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UI extends JFrame{
	/**private JTextField textField;
	JButton backward = new JButton("<<");
	JButton forward = new JButton(">>");
	JButton playpause = new JButton("\u64AD\u653E\u3001\r\n\r\u6682\u505C");
	JButton button = new JButton("\u6253\u5F00");
	JButton button_1 = new JButton("\u505C\u6B62");
	JFileChooser jf=new JFileChooser();
	JLabel LrcTop = new JLabel("\u8BF7");
	JSlider slider = new JSlider();
	JLabel LrcNextTop = new JLabel("\u70B9\u51FB");
	JLabel LrcCenter = new JLabel("\u5DE6\u4E0B\u89D2\u7684\u6253\u5F00");
	JLabel LrcDown = new JLabel("\u6253\u5F00\u4E00\u4E2A");
	JLabel LrcDownDown = new JLabel("\u6B4C\u8BCD\u6587\u4EF6");
	JButton start = new JButton("\u5F00\u59CB ");
	static String path;
	static LyricShow show = new LyricShow();
	static currentMills cm = new currentMills();
	public UI()  {
		
		setSize(760,520);
		setVisible(true);
		setTitle("\u6B4C\u8BCD\u64AD\u653E\u5668");
		getContentPane().setLayout(null);
		playpause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					cm.pause();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		playpause.setBounds(96, 423, 121, 19);
		getContentPane().add(playpause);
		
		backward.setBounds(369, 423, 49, 43);
		getContentPane().add(backward);
		forward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		forward.setBounds(682, 423, 49, 43);
		getContentPane().add(forward);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("00:00");
		textField.setBounds(415, 423, 269, 42);
		getContentPane().add(textField);
		textField.setColumns(10);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jf.showOpenDialog(rootPane);
				path=jf.getSelectedFile().toString();
				System.out.println(path.toString());
				try {
					show.Load(path);
					LrcCenter.setText(show.getReturns(path, 0));
					LrcTop.setText("");
					LrcNextTop.setText("");
					LrcDown.setText(show.getReturns(path, 1));
					LrcDownDown.setText(show.getReturns(path, 2));
				} catch (FileNotFoundException e1) {
					System.out.println("文件不存在");
				}catch(StringIndexOutOfBoundsException ee){
					System.out.println("不是歌词文件");
					//ee.printStackTrace();
				} catch (Exception e1) {
					System.out.println("其他异常.");
					e1.printStackTrace();
				}
			}
		});
		
		button.setBounds(14, 423, 68, 43);
		getContentPane().add(button);
		
		button_1.setBounds(229, 423, 63, 43);
		getContentPane().add(button_1);
		
		
		slider.setValue(0);
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setBounds(0, 384, 745, 26);
		getContentPane().add(slider);
		
		
		LrcTop.setFont(new Font("微软雅黑 Light", Font.PLAIN, 32));
		LrcTop.setHorizontalAlignment(SwingConstants.CENTER);
		LrcTop.setBounds(0, 29, 745, 43);
		getContentPane().add(LrcTop);
		
		
		LrcNextTop.setHorizontalAlignment(SwingConstants.CENTER);
		LrcNextTop.setFont(new Font("微软雅黑 Light", Font.PLAIN, 34));
		LrcNextTop.setBounds(0, 74, 745, 57);
		getContentPane().add(LrcNextTop);
		
		
		LrcCenter.setForeground(new Color(204, 0, 0));
		LrcCenter.setHorizontalAlignment(SwingConstants.CENTER);
		LrcCenter.setFont(new Font("微软雅黑 Light", Font.PLAIN, 46));
		LrcCenter.setBounds(0, 144, 745, 74);
		getContentPane().add(LrcCenter);
		
		
		LrcDown.setHorizontalAlignment(SwingConstants.CENTER);
		LrcDown.setFont(new Font("微软雅黑 Light", Font.PLAIN, 34));
		LrcDown.setBounds(0, 231, 745, 43);
		getContentPane().add(LrcDown);
		
		
		LrcDownDown.setHorizontalAlignment(SwingConstants.CENTER);
		LrcDownDown.setFont(new Font("微软雅黑 Light", Font.PLAIN, 32));
		LrcDownDown.setBounds(0, 287, 745, 43);
		getContentPane().add(LrcDownDown);
		
		
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//while(true){
					setLrc();
						//Thread.sleep(100);
					//}
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				
				
			}
		});
		start.setBounds(96, 441, 121, 26);
		getContentPane().add(start);
	}
	public void setLrc(){
		while(true){
			try {
				//Thread.sleep(1000);
				LrcTop.setText(show.getReturns(path, -2));
				LrcNextTop.setText(show.getReturns(path, -1));
				LrcCenter.setText(show.getReturns(path, 0));
				LrcDown.setText(show.getReturns(path, 1));
				LrcDownDown.setText(show.getReturns(path, 2));
				this.update(getGraphics());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new UI();
		
			
		
	}**/
	}

