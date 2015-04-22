package jmc.feol.core.service.impl.test;


	import java.io.File;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.awt.image.RenderedImage;
	import com.sun.image.codec.jpeg.JPEGCodec;
	import com.sun.image.codec.jpeg.JPEGImageEncoder;
	import com.sun.media.jai.codec.SeekableStream;
	import com.sun.media.jai.codec.FileSeekableStream;
	import com.sun.media.jai.codec.TIFFDecodeParam;
	import com.sun.media.jai.codec.ImageDecoder;
	import com.sun.media.jai.codec.ImageCodec;

	public class TestTifToJpg {

	  public static void TiffToJpg(String tiff, String output)
	     throws IOException
	  {
	    File tiffFile = new File(tiff);
	    SeekableStream s = new FileSeekableStream(tiffFile);
	    TIFFDecodeParam param = null;
	    ImageDecoder dec = ImageCodec.createImageDecoder("tiff", s, param);
	    RenderedImage op = dec.decodeAsRenderedImage(0);
	    FileOutputStream fos = new FileOutputStream(output);
	    JPEGImageEncoder jpeg = JPEGCodec.createJPEGEncoder(fos);
	    jpeg.encode(op.getData());
	    fos.close();
	  }

	  public static void main(String[] args) throws Exception {
		  TestTifToJpg.TiffToJpg("c:/Cheques/00701010580558725200000183264.tif",
	                        "c:/Cheques/00701010580558725200000183264.jpg");
	  }
	}

