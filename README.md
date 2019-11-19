# MapImg
Created for Minestar Network.
Programmed on Spigot 1.14.4

# Commands
```
/mapimg help - Displays a help message
/mapimg get <url> <width> <height> - Main command to get a Map Image
```

# User Instructions
Example of /mapimg get usage:
```
/mapimg get https://i5.walmartimages.ca/images/Large/094/504/6000200094504.jpg 2 2
```
The URL is (https://i5.walmartimages.ca/images/Large/094/504/6000200094504.jpg)
The width is 2 and the height is 2.
This would provide 4 maps in total and each containing a corner of the image.
You can go up to 6 x 6 as much (or as inventory can hold).

The coordinates will be displayed in each item, so you know how to assemble it
once you put them on the item frames. The top left is (0, 0) and as it descends,
the y-value increases. Think of a cartesian x-y grid but the y-axis is flipped.
