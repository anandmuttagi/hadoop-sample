package com.homeshop18.hadoop.map;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class UrlClickCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	private static int LANDING_URL_POS = 6;
	private final IntWritable ONE = new IntWritable(1);
	private Text word = new Text();

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected void map(LongWritable key, Text value, org.apache.hadoop.mapreduce.Mapper.Context context)
			throws IOException, InterruptedException {

		String line = value.toString();
		StringTokenizer tokenizer = new StringTokenizer(line);
		int count = 0;
		String urlToken = null;
		String[] urlSplitter = null;
		
		while (tokenizer.hasMoreTokens()) {
			count++;
			urlToken = tokenizer.nextToken();
			if (LANDING_URL_POS == count) {
				urlSplitter = urlToken.split(" ");
				if (urlSplitter.length == 3) {
					word.set(urlSplitter[2]);
					context.write(word, ONE);
				}
			}
		}

	}
}
