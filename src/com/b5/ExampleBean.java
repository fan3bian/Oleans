package com.b5;

import org.springframework.beans.factory.InitializingBean;

public class ExampleBean implements InitializingBean {
   public void afterPropertiesSet() {
      // do some initialization work
	   System.out.println("��ʼ���ص�����");
   }
}