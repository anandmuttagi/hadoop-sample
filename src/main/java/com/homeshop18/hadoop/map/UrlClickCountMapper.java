package com.homeshop18.hadoop.map;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class UrlClickCountMapper extends Mapper<LongWritable, Text, Text, IntWritable>{

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected void map(LongWritable key, Text value, org.apache.hadoop.mapreduce.Mapper.Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		super.map(key, value, context);
	}
}
