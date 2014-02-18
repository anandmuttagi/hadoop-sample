package com.homeshop18.hadoop.reduce;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class UrlClickCountReducer extends Reducer<Text, IntWritable, Text, IntWritable>{

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void reduce(Text arg0, Iterable<IntWritable> arg1, org.apache.hadoop.mapreduce.Reducer.Context arg2)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		super.reduce(arg0, arg1, arg2);
	}

}
