package kr.co.infopub.chapter.s151.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.text.AbstractDocument;
//벽을 상속받으면 자신이 벽
public class BaseBallJFrame extends JFrame 
implements ActionListener {

	private JPanel mainp;
	
	private JPanel np=new JPanel();
	private JPanel cp=new JPanel();
	
	private JPanel cp1=new JPanel();
	private JPanel cp2=new JPanel();
	
	
	private JPanel cnp=new JPanel();
	private JPanel ccp=new JPanel();
	private JPanel csp=new JPanel();
	
	private JLabel lbnp=new JLabel("HYO Base Ball!!",JLabel.CENTER );
	
	private JLabel lbcnp1=new JLabel("0",JLabel.CENTER );
	private JLabel lbcnp2=new JLabel("0",JLabel.CENTER );
	private JLabel lbcnp3=new JLabel("0",JLabel.CENTER );
	
	
	private JButton btnPlay=new JButton("Play Base Ball!!");
	
	private JPanel ccnp=new JPanel();
	private JPanel cccp=new JPanel();
	
	private JLabel lbresult=new JLabel("    Strike     Ball             ",JLabel.CENTER );
	
	private JButton btn01=new JButton("1");
	private JButton btn02=new JButton("2");
	private JButton btn03=new JButton("3");
	private JButton btn04=new JButton("4");
	private JButton btn05=new JButton("5");
	private JButton btn06=new JButton("6");
	private JButton btn07=new JButton("7");
	private JButton btn08=new JButton("8");
	private JButton btn09=new JButton("9");
	private JButton btn00=new JButton("0");
	private JButton btnRest=new JButton("Set");
	private JButton btnBat=new JButton("Bat");
	
	private JTable jtBall=new JTable();
	private JScrollPane jsp=new JScrollPane();
	//BallTableModel dataModel=new BallTableModel();
	//
	private Pitcher pit;
	private Hitter hit;
	private Umpire ump;
	int pressCount=0;
	int iterCount=0;
	int [] ball;
	ArrayList<BallData> balllists=new ArrayList<>();    
	public BaseBallJFrame()  {
		init();
		init2();
		addListener();
	}
	private void init2(){
		pit=new Pitcher();
		hit=new Hitter();
		ump=new Umpire();
	}
	
	private void addListener(){
		btnPlay.addActionListener( this  );
		btn01.addActionListener( this  );
		btn02.addActionListener( this  );
		btn03.addActionListener( this  );
		btn04.addActionListener( this  );
		btn05.addActionListener( this  );
		btn06.addActionListener( this  );
		btn07.addActionListener( this  );
		btn08.addActionListener( this  );
		btn09.addActionListener( this  );
		btn00.addActionListener( this  );
		btnRest.addActionListener( this  );
		btnBat.addActionListener( this  );
	}

	private void init(){
		//도화지 준비
		//border
		mainp=(JPanel)this.getContentPane();
		mainp.setLayout(new BorderLayout());
		lbnp.setFont(new Font(Font.SERIF, Font.BOLD, 30));
		np.setLayout(new BorderLayout());
		np.add(lbnp);
		
		mainp.add(BorderLayout.NORTH,np);
		mainp.add(BorderLayout.CENTER,cp);
		cp1.setBackground(Color.RED);
		cp2.setBackground(Color.BLUE);
		cp.setLayout(new GridLayout(1,2));
		cp.add(cp1);
		cp.add(cp2);
		
		cp1.setLayout(new BorderLayout());
		cp1.add(BorderLayout.NORTH,cnp);
		cp1.add(BorderLayout.CENTER,ccp);
		cp1.add(BorderLayout.SOUTH,csp);
		
		lbcnp1.setFont(new Font(Font.SERIF, Font.BOLD, 30));
		lbcnp2.setFont(new Font(Font.SERIF, Font.BOLD, 30));
		lbcnp3.setFont(new Font(Font.SERIF, Font.BOLD, 30));
		cnp.add(lbcnp1);
		cnp.add(lbcnp2);
		cnp.add(lbcnp3);
		
		btnPlay.setFont(new Font(Font.SERIF, Font.BOLD, 20));
		csp.add(btnPlay);
		
		ccp.setLayout(new BorderLayout());
		ccp.add(BorderLayout.NORTH,ccnp);
		ccp.add(BorderLayout.CENTER,cccp);
		lbresult.setFont(new Font(Font.SERIF, Font.BOLD, 20));
		ccnp.setLayout(new BorderLayout());
		ccnp.add(lbresult);
		
		cccp.setLayout(new GridLayout(4,3));
		
		btn01.setFont(new Font(Font.SERIF, Font.BOLD, 20));
		btn02.setFont(new Font(Font.SERIF, Font.BOLD, 20));
		btn03.setFont(new Font(Font.SERIF, Font.BOLD, 20));
		btn04.setFont(new Font(Font.SERIF, Font.BOLD, 20));
		btn05.setFont(new Font(Font.SERIF, Font.BOLD, 20));
		btn06.setFont(new Font(Font.SERIF, Font.BOLD, 20));
		btn07.setFont(new Font(Font.SERIF, Font.BOLD, 20));
		btn08.setFont(new Font(Font.SERIF, Font.BOLD, 20));
		btn09.setFont(new Font(Font.SERIF, Font.BOLD, 20));
		btn00.setFont(new Font(Font.SERIF, Font.BOLD, 20));
		btnRest.setFont(new Font(Font.SERIF, Font.BOLD, 20));
		btnBat.setFont(new Font(Font.SERIF, Font.BOLD, 20));
		
		cccp.add(btn01);
		cccp.add(btn02);
		cccp.add(btn03);
		cccp.add(btn04);
		cccp.add(btn05);
		cccp.add(btn06);
		cccp.add(btn07);
		cccp.add(btn08);
		cccp.add(btn09);
		cccp.add(btnRest);
		cccp.add(btn00);
		cccp.add(btnBat);
		
		jtBall=new JTable();
		jsp=new JScrollPane(jtBall);
		cp2.setLayout(new BorderLayout());
		cp2.add(jsp);
		
		BallTableModel dataModel=new BallTableModel();
		jtBall.setModel(dataModel);
		jsp.updateUI();
		settingButton(false);
	}
	
	//nested ==inner
	public class BallTableModel extends 
	AbstractTableModel{

		ArrayList<BallData> datas=new ArrayList<>();
		String [] heads={"회차","Ball1", "Ball2",
				"Ball3","Strike", "Ball"};
		
		public BallTableModel() {
			datas.clear();
		}
		
		public void setDatas(ArrayList<BallData> datas) {
			this.datas = datas;
		}
		@Override
		public String getColumnName(int column) {
			return heads[column];
		}
		@Override
		public int getRowCount() {
			return datas.size();
		}

		@Override
		public int getColumnCount() {
			return heads.length;
		}
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			BallData bdata=datas.get(rowIndex);
			String value="";
			switch (columnIndex) {
				case 0: value=bdata.getRound()+"";break;
				case 1: value=bdata.getBall1()+"";break;
				case 2: value=bdata.getBall2()+"";break;
				case 3: value=bdata.getBall3()+"";break;
				case 4: value=bdata.getStrike()+"";break;
				case 5: value=bdata.getBall()+"";break;
			}
			return value;
		}
		
	}
	//시작, 히팅 버튼을 보이거나 안보이게
    public void setting(boolean s){
        	btnRest.setVisible(!s);
            btnBat.setVisible(!s);
            btnPlay.setVisible(s);
    }
    //번호버튼을 보이거나 안보이게
    public void settingButton(boolean s){
            btn00.setVisible(s);
            btn01.setVisible(s);
            btn02.setVisible(s);
            btn03.setVisible(s);
            btn04.setVisible(s);
            btn05.setVisible(s);
            btn06.setVisible(s);
            btn07.setVisible(s);
            btn08.setVisible(s);
            btn09.setVisible(s);
    }
    //투수가 공을 던지고 심판에게 입력
    public void startGame(){
        pit.make();//서로 다른 세수 만들기->투수 공던지기
        ball=new int[3];//타자용 공 준비
        ump.setPitBall(pit.getGong());//심판에 넣기
    }
    private void lbClear(){
    	 lbcnp1.setText("");
         lbcnp2.setText("");
         lbcnp3.setText("");
    }
    int count=0;
	@Override
	public void actionPerformed(ActionEvent v) {
		if(v.getSource()==btnPlay){//시작을 누르면
            setting(false);
            settingButton(true);
            startGame();
            pressCount=0;//3개 버튼 누르기
            iterCount=0;//10번 안에 맞추기
            lbresult.setText("Base Ball Game!!");
            lbClear();
            //----------------------------------
            //리스트를 제거하고 아답터를 이용하여 리스트뷰에 반영한다.
            balllists.clear();
            BallTableModel dataModel=new BallTableModel();
            dataModel.setDatas(balllists);
            jtBall.setModel(dataModel);
        }else if(v.getSource()==btnRest){
            settingButton(true);
            pressCount=0;//3개 버튼 누르기
            lbClear();
        }else if(v.getSource()==btn00){
            setNums(toNum(btn00.getText().toString()),btn00);
        }else if(v.getSource()==btn01){
            setNums(toNum(btn01.getText().toString()),btn01);
        }else if(v.getSource()==btn02){
            setNums(toNum(btn02.getText().toString()),btn02);
        }else if(v.getSource()==btn03){
            setNums(toNum(btn03.getText().toString()),btn03);
        }else if(v.getSource()==btn04){
            setNums(toNum(btn04.getText().toString()),btn04);
        }else if(v.getSource()==btn05){
            setNums(toNum(btn05.getText().toString()),btn05);
        }else if(v.getSource()==btn06){
            setNums(toNum(btn06.getText().toString()),btn06);
        }else if(v.getSource()==btn07){
            setNums(toNum(btn07.getText().toString()),btn07);
        }else if(v.getSource()==btn08){
            setNums(toNum(btn08.getText().toString()),btn08);
        }else if(v.getSource()==btn09){
            setNums(toNum(btn09.getText().toString()),btn09);
        }else if(v.getSource()==btnBat && pressCount==3){
            iterCount++;//히팅한 수--> 10번 이하에 맞추어야한다.
            hit.make(ball);
            ump.setHitBall(hit.getGong());
            //-------------이곳 수정 요망
            balllists.add(showHit());
            BallTableModel dataModel=new BallTableModel();
            dataModel.setDatas(balllists);
            jtBall.setModel(dataModel);
            //---------------
            if(iterCount<10){
                if(ump.strike()==3){
                    winGame();//win game
                    
                }else{
                    contGame();//continue game
                }
            }else{
                lostGame();//lost game
                
            }
        }
		mainp.updateUI();
	}
    
    private void showHint(){
        String str=String.format("%d Strike %d Ball!!",
                ump.strike(),ump.ball() );
        lbresult.setText(str);
    }//
    private String showHint2(){
        int[]mmm=pit.getGong();
        String st=String.format("[%d : %d : %d]",
                mmm[0],mmm[1],mmm[2] );
        return st;
    }
    private String showHit3(){
        String str=String.format("%dS%dB",
                ump.strike(),ump.ball() );
        int[]mmm=hit.getGong();
        String st=String.format("%s:[%d:%d:%d]",
                str,mmm[0],mmm[1],mmm[2] );
        return st;
    }
    private BallData showHit(){
        BallData data=new BallData();
        data.setRound(iterCount);
        data.setStrike(ump.strike());
        data.setBall(ump.ball());
        data.setBall1(hit.getGong()[0]);
        data.setBall2(hit.getGong()[1]);
        data.setBall3(hit.getGong()[2]);
        return data;
    }
    private void winGame(){
    	this.lbresult.setText("축하합니다.("+iterCount+"회)");
        setting(true);
        settingButton(false);
        startGame();
        pressCount=0;//3개 버튼 누르기
        iterCount=0;//10번 안에 맞추기
    }
    private void lostGame(){
    	this.lbresult.setText("Out! =>"+showHint2());
        setting(true);
        settingButton(false);
        startGame();
        pressCount=0;//3개 버튼 누르기
        iterCount=0;//10번 안에 맞추기
    }
    private void contGame(){
        showHint();
        pressCount=0;//3개 버튼 누르기
        settingButton(true);
    }
    private int toNum(String msg){
        return Integer.parseInt(msg.trim());
    }
    private void setNums(int number, JButton bu){
        if(pressCount>2){
            settingButton(false);
        }else{
            ball[pressCount]=number;
            if(pressCount==0){
                lbcnp1.setText(ball[pressCount]+"");
                lbcnp2.setText("");
                lbcnp3.setText("");
            }else if(pressCount==1){
            	lbcnp2.setText(ball[pressCount]+"");
            	lbcnp3.setText("");
            }else if(pressCount==2){
            	lbcnp3.setText(ball[pressCount]+"");
            }
            bu.setVisible(false);
            pressCount++;
        }
    }
}
