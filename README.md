# CONFIG

* Java 8
* Gradle 8
* Intellij Idea Community

## INFO

* Folder 'examples' for the images and other files
* Folder 'libs' for the jars to use offline
* Folder 'temporary' for the outputs after actions

### LIBS

* **Java Core**:

```
Reader names: [JPG, jpg, bmp, BMP, wbp, WBP, gif, GIF, WBMP, png, PNG, JPEG, JPEG-LOSSLESS, webp, WEBP, jpeg, wbmp, jpeg-lossless]

Reader MIME types: [image/png, image/vnd.wap.wbmp, image/x-png, image/jpeg, image/bmp, image/gif, image/x-webp, image/webp]

Writer names: [JPG, jpg, bmp, BMP, gif, GIF, WBMP, png, PNG, wbmp, jpeg, JPEG]

Writer MIME types: [image/png, image/vnd.wap.wbmp, image/x-png, image/jpeg, image/bmp, image/gif]
```

1. **Graphics 2D**
2. **Java ImageIO**

* **Apache Commons** [link](https://commons.apache.org/):

```
Image Format Support:
- BMP Read:yes / Write:yes
- GIF Read:yes / Write:yes
- JPEG/JFIF Read:some / Write:on
- ICNS Read:mostly / Write:mostly
- ICO/CUR Read:yes / Write:mostly
- PCX/DCX Read:yes / Write:yes
- PNM/PGM/PBM/PPM/PAM Portable Pixmap Read:yes / Write:mostly
- PNG Read:yes / Write:yes
- PSD/Photoshop Read:yes / Write:no
- PSD/Photoshop Read:yes / Write:no
- RGBE/Radiance HDR Read:yes / Write:no
- TIFF Read:yes / Write:yes
- WBMP Read:yes / Write:yes
- XBM Read:yes / Write:yes
- XPM Read:yes / Write:yes
```

```
Metadata Format Support:
- JPEG/JFIF EXIF Metadata Read:yes / Write:yes
- JPEG/JFIF IPTC Metadata Read:yes / Write:soon
- JXMP Metadata Read:yes / Write:yes
```

*  **Google Guava** [link](https://github.com/google/guava):
* 
```
Does not read/write images!!!
```

* **Marvin** [link](https://marvinproject.net/en/index.html):

```
Work only with jpg format!!!
```

* **Imgscalr** [link](http://www.thebuzzmedia.com/software/imgscalr-java-image-scaling-library/):

```
The same formats as Java core. Convert an image to the same extension as converted.
```

* **Thumbnailator** [link](https://github.com/coobird/thumbnailator):

```
By default, Java 6 and beyond support reading and writing of JPEG, PNG, GIF, BMP and WBMP formats; 
Java 5 did not support writing GIF files.
```

* **TwelveMonkeys** [link](https://github.com/haraldk/TwelveMonkeys):

```
Image Format Support:
- SVG Read:yes / Write:yes
- GIF Plugin:Batik Read:yes / Write:on
- WMF Plugin:Batik Read:yes / Write:on
- BMP Plugin:BMP Read:yes / Write:yes
- CUR Plugin:BMP Read:yes / Write:on
- ICO Plugin:BMP Read:yes / Write:yes
- HDR Plugin:HDR Read:yes / Write:on
- ICNS Plugin:ICNS Read:yes / Write:yes
- IFF Plugin:IFF Read:yes / Write:yes
- JPEG Plugin:JPEG Read:yes / Write:yes
- JPEG Lossless Plugin:JPEG Read:yes / Write:on
- PCX Plugin:PCX Read:yes / Write:on
- DCX Plugin:PCX Read:yes / Write:on
- PICT Plugin:PICT Read:yes / Write:yes
- PNTG Plugin:PICT Read:yes / Write:on
- PAM Plugin:PNM Read:yes / Write:yes
- PBM Plugin:PNM Read:yes / Write:on
- PGM Plugin:PNM Read:yes / Write:on
- PPM Plugin:PNM Read:yes / Write:yes
- PFM Plugin:PNM Read:yes / Write:on
- PSD Plugin:PSD Read:yes / Write:yes
- PSB Plugin:PSD Read:yes / Write:on
- SGI Plugin:SGI Read:yes / Write:on
- TGA Plugin:TGA Read:yes / Write:yes
- TGA Plugin:TGA Read:yes / Write:yes
- ThumbsDB Plugin:ThumbsDB Read:yes / Write:on
- TIFF Plugin:TIFF Read:yes / Write:yes
- BigTIFF Plugin:TIFF Read:yes / Write:yes
- WebP Plugin:WebP Read:yes / Write:on
- XWD Plugin:XWD Read:yes / Write:on
```
* **Scrimage** [link](https://sksamuel.github.io/scrimage/) {Good choice!}:

```
png, jpeg, gif, tiff, webp
```

TODO avif