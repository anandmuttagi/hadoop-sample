package com.homeshop18.hadoop.reduce;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class UrlClickCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void reduce(Text key, Iterable<IntWritable> values, org.apache.hadoop.mapreduce.Reducer.Context context)
			throws IOException, InterruptedException {
		int clickCount = 0;
		for (IntWritable value : values) {
			clickCount += value.get();
		}
		context.write(key, new IntWritable(clickCount));
	}

}
