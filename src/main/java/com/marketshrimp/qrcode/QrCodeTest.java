package com.marketshrimp.qrcode;
 
public class QrCodeTest {
 
	public static void main(String[] args) throws Exception {
		// 存放在二维码中的内容
		String text = "https://blog.csdn.net/jam_fanatic/article/details/82818857";
		// 嵌入二维码的图片路径
		String imgPath = "C:\\IDEA\\workspace\\netty_lecture\\src\\main\\java\\com\\marketshrimp\\qrcode\\20180923010802416.jpg";
		// 生成的二维码的路径及名称
		String destPath = "C:\\IDEA\\workspace\\netty_lecture\\src\\main\\java\\com\\marketshrimp\\qrcode\\jam.jpg";
		//生成二维码
		QRCodeUtil.encode(text, imgPath, destPath, true);
		// 解析二维码
		String str = QRCodeUtil.decode(destPath);
		// 打印出解析出的内容
		System.out.println(str);
 
	}
 
}