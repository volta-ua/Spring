package container;

public class Demo {

	public static void main(String[] args) {
		
		MyArray arr=new MyArray();
		
		arr.put("��");
		arr.put("����");
		arr.put("��");
		arr.put("���������");
		arr.put(null);
		arr.put("����");
		arr.put("��");
		arr.put("�����");
		arr.put("�����");
		arr.put("�����");
		arr.put("��������");
		arr.put("��");
		arr.put("�����");
		arr.put("����");
		
		for (int i=0;i<15;i++)
			System.out.println(arr.get());
				
	}

}
