package com.example.sqlinject.key;

import com.example.sqlinject.Service.SqlService;

import java.security.SecureRandom; //난수생성기 import

public class RandomKeyGenerator implements KeyGenerator{ //keygenerator 클래스를 부모상속자로 받아서 override 한다)

    /* (non-Javadoc)
     * @see com.raon.onepass.common.keygen.KeyGenerator#nextKey()
     */
    @Override
    public String nextKey() {     //next + key(공백이 생기기전까지의 난수키를 모두 받는다
        long time = System.currentTimeMillis(); //16바이트(64bit)로 time변수에다가 현재 시간을 대입한다
        long s1 = new SecureRandom().nextLong(); //16바이트로 난수 생성기를 통해 생성된 숫자를 대입
        long s2 = new SecureRandom().nextLong(); //16바이트로 난수 생성기를 통해 생성된 숫자를 대입
        long s3 = new SecureRandom().nextLong(); //16바이트로 난수 생성기를 통해 생성된 숫자를 대입

        String temp = Long.toHexString(((time & s1) | s2) ^ s3).toUpperCase(); //비트 연산자: time을 비트로 변환하여 s1과 비교할때 하나라도 1이있다면 1로변환된다 그것을 |S2 와 비교하여
        //S2와 앞에서 비교한게 모두 1일때만 1로 변환하고temp변수에 16진수로 변환된 값을 변환(소문자는 대문자로) s3 를 xor 논리연산함
        //비트 xor : 비트에서 하나는 1 이고 다른 하나는 0 일때만 1로 반환

        for ( int i=temp.length(); i< KeyGenerator.KEY_SIZE; i++ )			   //int i = temp의 길이 부터 시작 ; i는 keyGenerator.key_size(20)까지 범위; 1씩 더한다
            temp += new SecureRandom().nextInt(10);							   //securerandom을 불러와서 생성된 난수 10자리까지만 받는다

        return temp; 														   //temp 리턴
    }

    /* (non-Javadoc)
     * @see com.raon.onepass.common.keygen.KeyGenerator#nextNumberKey()
     */
    @Override
    public String nextNumberKey() {

        long time = System.currentTimeMillis();
        long s1 = new SecureRandom().nextLong();
        long s2 = new SecureRandom().nextLong();
        long s3 = new SecureRandom().nextLong();

        String temp = Long.toString(Math.abs(((time & s1) | s2) ^ s3));	 	//time과 S1은 비트로 변환하여 둘중 하나가 1이면 1로, 이걸 S2와 비교하여 둘다 1일경우 1로 이걸 xor연산으로 s3과 비교한것을 최대값으로 출력하고 이를 문자로 바꿈

        for ( int i=temp.length(); i< KeyGenerator.KEY_SIZE; i++ )
            temp += new SecureRandom().nextInt(10);

        return temp;
    }

    /* (non-Javadoc)
     * @see com.raon.onepass.common.keygen.KeyGenerator#nextSeqNumberKey()
     */
    @Override
    public synchronized String nextSeqNumberKey() { //synchronized 한 스레드만 한 블록안으로 접근 나머지는 첫 스레드가 마칠때가지 접근 불가

        long time = 0;
//		try {
//			Thread.sleep(1);
        time = System.currentTimeMillis();
//		} catch (InterruptedException e) {
//
//		}
        String temp = Long.toString(time);
        for ( int i=temp.length(); i< KeyGenerator.KEY_SIZE; i++ )
            temp += new SecureRandom().nextInt(10);

        return temp;
    }

    @Override
    public synchronized String nextBackupKey() {

        long time = 0;
//		try {								//try {Thread.sleep(대기시간); 문제발생 예상코드;} catch (InturruptedException e) 예외발생시 {}
//			Thread.sleep(1);
        time = System.currentTimeMillis();
//		} catch (InterruptedException e) {
//
//		}
        String temp = Long.toString(time % (60*60*1000));	// per hour
        for ( int i=temp.length(); i< KeyGenerator.KEY_SIZE; i++ )
            temp += new SecureRandom().nextInt(10);

        return temp;
    }
}