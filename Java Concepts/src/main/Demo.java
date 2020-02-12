package main;

public class Demo extends Parent{
	public void Show()
	{
		System.out.println("Child Method");
	}
	public static void main(String[] args) {
		Parent objParent=new Demo();
		objParent.Show();	//Child Method
		objParent=new Parent();
		objParent.Show();	//Parent Method
		
		Demo objDemo=new Demo();
		System.out.println("Demo Class");
		objDemo.Show();

	}

}
