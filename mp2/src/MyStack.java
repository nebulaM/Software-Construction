/*
 * Implementation of a simple stack for HtmlTags.
 * You should implement this class.
 */

import java.util.ArrayList;

public class MyStack {
	// An ArrayList to hold HtmlTag objects.
	private ArrayList<HtmlTag> stack_internal;

	/*
	 * Create an empty stack.
	 */
	public MyStack( ) {
		this.stack_internal = new ArrayList<HtmlTag>( );
	}

	/*
	 * Push a tag onto the top of the stack.
	 */
	public void push( HtmlTag tag ) {
		stack_internal.add(tag);
	}

	/*
	 * Removes the tag at the top of the stack.
	 * Should throw an exception if the stack is empty.
	 */
	public HtmlTag pop( ) {
		if(stack_internal.isEmpty()){
		    throw new NullPointerException("Stack is null");
        }
		return stack_internal.remove(stack_internal.size()-1);
	}

	/*
	 * Looks at the object at the top of the stack but
	 * does not actually remove the object.
	 * Should throw an exception if the stack is empty.
	 */
	public HtmlTag peek( ) {
        if(stack_internal.isEmpty()){
            return null;
        }
        return stack_internal.get(stack_internal.size()-1);
	}

	/*
	 * Tests if the stack is empty.
	 * Returns true if the stack is empty;
	 * false otherwise.
	 */
	public boolean isEmpty( ) {
        return stack_internal.isEmpty();
	}
}
