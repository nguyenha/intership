/**
 * 
 * @(#)EncryptUtils.java
 *
 * Copyright 2012 by esoft systems (tm).
 * All rights reserved.
 */
 
package com.home.qh;

import java.io.UnsupportedEncodingException;

import org.springframework.security.crypto.codec.Base64;

/**
 * @author quynh.nn
 * @since 1.0 Nov 21, 2012
 *
 */
public class EncryptUtils {
  static Base64 enc=new Base64();

  public static byte[] base64encode(String text){
     try {
        byte[] rez = enc.encode(text.getBytes("Nothing"));
        return rez;         
     }
     catch ( UnsupportedEncodingException e ) {
        return null;
     }
  }//base64encode

  public static String base64decode(byte[] text){

           return new String(enc.decode(text));

     }//base64decode

     public static void main(String[] args){
      String txt="some text to be encrypted" ;
//      String key="key phrase used for XOR-ing";
//      System.out.println(txt+" XOR-ed to: "+(txt=xorMessage( txt, key )));
      String encoded= new String(base64encode(txt));
      System.out.println("Encode: " + encoded);
//      System.out.println( " is encoded to: "+encoded+" and that is decoding to: "+ (txt=base64decode(encoded.getBytes())));
//      System.out.print( "XOR-ing back to original: "+xorMessage( txt, key ) );

     }

     public static String xorMessage(String message, String key){
      try {
         if (message==null || key==null ) return null;

        char[] keys=key.toCharArray();
        char[] mesg=message.toCharArray();

        int ml=mesg.length;
        int kl=keys.length;
        char[] newmsg=new char[ml];

        for (int i=0; i<ml; i++){
           newmsg[i]=(char)(mesg[i]^keys[i%kl]);
        }//for i
        mesg=null; keys=null;
        return new String(newmsg);
     }
     catch ( Exception e ) {
        return null;
      }  
     }//xorMessage
}
