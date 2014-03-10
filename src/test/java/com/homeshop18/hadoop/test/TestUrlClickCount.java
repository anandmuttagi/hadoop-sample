package com.homeshop18.hadoop.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.apache.hadoop.mrunit.mapreduce.MapReduceDriver;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.junit.Before;
import org.junit.Test;

import com.homeshop18.hadoop.map.UrlClickCountMapper;
import com.homeshop18.hadoop.reduce.UrlClickCountReducer;

public class TestUrlClickCount {

	MapDriver<LongWritable, Text, Text, IntWritable> mapDriver;
	ReduceDriver<Text, IntWritable, Text, IntWritable> reduceDriver;
	MapReduceDriver<LongWritable, Text, Text, IntWritable, Text, IntWritable> mapReduceDriver;

	@Before
	public void setUp() {
		UrlClickCountMapper mapper = new UrlClickCountMapper();
		UrlClickCountReducer reducer = new UrlClickCountReducer();
		mapDriver = MapDriver.newMapDriver(mapper);
		reduceDriver = ReduceDriver.newReduceDriver(reducer);
		mapReduceDriver = MapReduceDriver.newMapReduceDriver(mapper, reducer);
	}

	@Test
	public void testMapper() {
		String input = "192.168.24.223 - - [10/Feb/2014:12:00:06 +0530] 0 \"GET /product/loadRecommendedProductsForUser HTTP/1.0\" 200 20 0 " +
				"\"http://www.homeshop18.com/\" \"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1700.107 Safari/537.36\" " +
				"\"BC4926126E716B7609C2D9C9CE7A6425-n1.jvmnode7\" \"d15e1332544c5a398ca0df434cc686bab34ea8300297e0e2be402ab7f49c7020\" @192.168.24.223, 210.212.88.61@";
		mapDriver.withInput(new LongWritable(), new Text(input));
		mapDriver.withOutput(new Text("/product/loadRecommendedProductsForUser"), new IntWritable(1));
		mapDriver.runTest();
	}

	@Test
	public void testReducer() {
		List<IntWritable> values = new ArrayList<IntWritable>();
		values.add(new IntWritable(1));
		values.add(new IntWritable(1));
		reduceDriver.withInput(new Text("/product/loadRecommendedProductsForUser"), values);
		reduceDriver.withOutput(new Text("/product/loadRecommendedProductsForUser"), new IntWritable(2));
		reduceDriver.runTest();
	}

}
