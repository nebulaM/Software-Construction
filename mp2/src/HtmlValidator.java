import java.util.LinkedList;
import java.util.Queue;

/*
 * This is the HtmlValidator class.
 * You should implement this class.
 */
public class HtmlValidator {

    private Queue<HtmlTag> mTagsQ;


    public HtmlValidator(){
        mTagsQ=new LinkedList <>();
    }
    public HtmlValidator(Queue<HtmlTag> tags){
        mTagsQ=new LinkedList<>();
        mTagsQ.addAll(tags);
    }

    /**
     * add a new tag to mTagsQ
     * @param tag not null
     */
    public void addTag(HtmlTag tag){
        if(tag==null){
            throw new IllegalArgumentException("tag cannot be null");
        }
        mTagsQ.add(tag);
    }

    public Queue<HtmlTag> getTags(){
        return mTagsQ;
    }

    /**
     * remove all tags in queue mTagsQ that (partially) contains "element"
     * @param element not null
     */
    public void removeAll(String element){
        if(element==null || element.equals("")){
            return;
        }
        for(HtmlTag tag: mTagsQ){
            if(tag.toString().contains(element)){
                mTagsQ.remove(tag);
            }
        }
        System.out.println(mTagsQ);
    }

    /**
     * 
     * @return validation result as a String 
     */
    public String validate(){
        MyStack mTagsS=new MyStack();
        StringBuilder sb=new StringBuilder();
        int countIndent=0;
        for(HtmlTag tag : mTagsQ){
            //do not increase indent for selfClosing tags
            if(tag.isSelfClosing()){
                sb=appendIntends(sb,countIndent);
                sb.append(tag.toString());
                sb.append("\n");
            }else if(tag.isOpenTag()){
                sb=appendIntends(sb,countIndent);
                sb.append(tag.toString());
                sb.append("\n");
                countIndent++;
                //push all openTags on stack for future use
                mTagsS.push(tag);
            }else {//isCloseTag
                if (mTagsS.peek()!=null&&mTagsS.peek().matches(tag)) {
                    countIndent--;
                    sb=appendIntends(sb,countIndent);
                    sb.append(tag.toString());
                    sb.append("\n");
                    mTagsS.pop();
                } else {
                    sb.append("ERROR unexpected tag: ");
                    sb.append(tag.toString());
                    sb.append("\n");
                }
            }
        }
        while(!mTagsS.isEmpty()){
            sb.append("ERROR unclosed tag: ");
            sb.append(mTagsS.pop().toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     *
     * @param sb StringBuilder
     * @param countIndent how many indent
     * @return StringBuilder w/ proper indent
     */
    private StringBuilder appendIntends(StringBuilder sb, int countIndent){
        while (countIndent>0){
            sb.append("    ");
            countIndent--;
        }
        return sb;
    }
}
