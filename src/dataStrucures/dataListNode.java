package dataStrucures;


public class dataListNode {
	
            private Object Container;

            public Object getContainer() {
                return Container;
            }

            public void setContainer(Object Container) {
                this.Container = Container;
            }
            
            private dataListNode next;

			/**
			 * Getter of the property <tt>next</tt>
			 * @return  Returns the next.
			 * @uml.property  name="next"
			 */
			public dataListNode getNext() {
				return next;
			}

			/**
			 * Setter of the property <tt>next</tt>
			 * @param next  The next to set.
			 * @uml.property  name="next"
			 */
			public void setNext(dataListNode next) {
				this.next = next;
			}

			/**
			 * @uml.property  name="previous"
			 */
			private dataListNode previous;

			/**
			 * Getter of the property <tt>previous</tt>
			 * @return  Returns the previous.
			 * @uml.property  name="previous"
			 */
			public dataListNode getPrevious() {
				return previous;
			}

			/**
			 * Setter of the property <tt>previous</tt>
			 * @param previous  The previous to set.
			 * @uml.property  name="previous"
			 */
			public void setPrevious(dataListNode previous) {
				this.previous = previous;
			}

		

}
