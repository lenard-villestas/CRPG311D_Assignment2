package utilities;

/**
 * class for XMLTag type
 * @author Lenard
 *
 */
public class XMLTag {
	//Attributes
		private String tagName;
		private int line;
		private boolean closeTag;
		/**
		 * @return the tagName
		 */
		public String getTagName() {
			return tagName;
		}
		/**
		 * @param tagName the tagName to set
		 */
		public void setTagName(String tagName) {
			this.tagName = tagName;
		}
		/**
		 * @return the line
		 */
		public int getLine() {
			return line;
		}
		/**
		 * @param line the line to set
		 */
		public void setLine(int line) {
			this.line = line;
		}
		/**
		 * @return the closeTag
		 */
		public boolean isCloseTag() {
			return closeTag;
		}
		/**
		 * @param closeTag the closeTag to set
		 */
		public void setCloseTag(boolean closeTag) {
			this.closeTag = closeTag;
		}
		
		//constructor
		
		

}
