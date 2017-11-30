
package creatingprimitivestream;
//why use: We have been using Wrapper Classes when we needed primitives to go into Streams.
//we did this using API so it feels Natural.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreatingPrimitiveStream {

    public static void main(String[] args) {
       //How we used code before Primitive Streams.
       Stream<Integer> stream=Stream.of(1,2,3,5);
       System.out.println(stream.reduce(0,(s,n)->s+n));
       
       //Not Bad. Its not hard to write reduction.we started Accumulator with zero ,added each number to
       //that running total and it comes out as a Stream.
       Stream<Integer> stream1=Stream.of(1,2,3);
       System.out.println(stream1.mapToInt(x->x).sum()); //Converted stream into Integer Stream and calculate Sum for Us
       System.out.println("===========Primitive Streams==========================");
       //Creating Primitive Streams..
       DoubleStream oneValue=DoubleStream.of(3.14);
       DoubleStream varArguments=DoubleStream.of(12,3,4.4,5.5);
       oneValue.forEach(System.out:: println);
       varArguments.forEach(System.out:: println);
       System.out.println("==We can also Creat Infinite Stream and Limit them using Primitive Streams==");
       DoubleStream random=DoubleStream.generate(Math:: random);
       DoubleStream iterate=DoubleStream.iterate(.5, e->e/2);
       random.limit(3).forEach(System.out:: println);
       iterate.limit(3).forEach(System.out:: println);
       
       System.out.println("=============================================");
       //Given code prints a Stream from numbers through 1 to 5...
       IntStream range=IntStream.iterate(1, n->n+1).limit(5);
       range.forEach(System.out:: println);
       System.out.println();
       //can be replaced by the short code which use range method
       IntStream range1=IntStream.range(1, 6);
       IntStream range2=IntStream.rangeClosed(1, 6);
       range1.forEach(System.out:: println);
       System.out.println();
       range2.forEach(System.out:: println);
       System.out.println("=====Double Stream usnig a mapToDouble function==============");
       Stream<String> objstream=Stream.of("penguin","fish");
       //IntStream intStream=objstream.mapToInt(s->s.length());
       //intStream.forEach(System.out:: println);
       //It will give error if you have used the stream once you cant use that again.
       DoubleStream db=objstream.mapToDouble(s->s.length());
       db.forEach(System.out::println);
       System.out.println("=====Mapping Methods btw types of Stream=============");
       //mapToObject: Returns a new Stream and uses double function as a parameter.
        DoubleStream doubleStream1=DoubleStream.of(1.2,2.2,3.3,3.4);
        doubleStream1.mapToObj(n->{return n*n +" ";}).forEach(System.out::println);
        System.out.println("--------");
       //map: Returns an Stream and uses Double unary Operator as a parameter.
        DoubleStream doubleStream2=DoubleStream.of(1.2,2.2,3.3,3.4);
        doubleStream2.map(s->s*s).forEach(System.out:: println);
        System.out.println("--------");
        //mapToInteger: Returns an int Stream and uses a DoubleToInt as a parameter.
        DoubleStream doubleStream3=DoubleStream.of(1.2,2.2,3.3,3.4);
        doubleStream3.mapToInt(s->{return (int)(s*s);}).forEach(System.out::println);
        //mapToLong: Returns an long Stream and uses a DoubleToLong as a parameter.
        System.out.println("--------");
        DoubleStream doubleStream4=DoubleStream.of(1.2,2.2,3.3,3.4);
        doubleStream4.mapToLong(s->{return (long)(s*s);}).forEach(System.out::println);
        System.out.println("-------FlatMapToInt-------------");
        List<String> list=Arrays.asList("2","3","33","44");
        list.stream().flatMapToInt(x->IntStream.of(Integer.parseInt(x))).forEach(System.out:: println);
        //parseInt converts String to Int and returns the result in Int.
        
        
        
       
       
    }
    
}
