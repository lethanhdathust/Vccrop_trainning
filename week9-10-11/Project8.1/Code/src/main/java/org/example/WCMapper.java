package org.example;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.StringTokenizer;

public class WCMapper extends Mapper<LongWritable , Text,Text, IntWritable> {
//    It re
    private final static IntWritable one = new IntWritable(1);
    // We can ignore the key and only work with value

    private Text word = new Text();

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        StringTokenizer itr = new StringTokenizer(value.toString());
        while (itr.hasMoreTokens()) {
            word.set(itr.nextToken());
            context.write(word, one);
        }
    }
//    @Override
//    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context) throws IOException, InterruptedException {
//        super.map(key, value, context);
//        String [] words= value.toString().split(" ");
//        for (String word :
//                words) {
//            context.write(new Text(word.toLowerCase()),new IntWritable(1) );
//        }
//    }

    public static void main(String[] args) {

    }
}
