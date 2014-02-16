/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fileIO;

import java.io.*;

/**
 *
 * @author Travis
 */
public class stream {
    private File fileName;
    private boolean fileLoadErrorFlag;
    private boolean fileSaveErrorFlag;
    //=======================================================
     public boolean isFileLoadErrorFlag() {
        return fileLoadErrorFlag;
    }

    public void setFileLoadErrorFlag(boolean fileLoadErrorFlag) {
        this.fileLoadErrorFlag = fileLoadErrorFlag;
    }

    public boolean isFileSaveErrorFlag() {
        return fileSaveErrorFlag;
    }

    public void setFileSaveErrorFlag(boolean fileSaveErrorFlag) {
        this.fileSaveErrorFlag = fileSaveErrorFlag;
    }

    //=========================================================

    public File getFileName() {
        return fileName;
    }

    public void setFileName(File fileName) {
        this.fileName = fileName;
    }
    //============================================================

    public Object openStreamInput(){
			ObjectInputStream objectInput = null;
            FileInputStream fileInput = null;
            Object returnvar = null;
        if(getFileName().canRead()){
                 try{
                     //getFileName().
                     fileInput = new FileInputStream(getFileName());
                     objectInput = new ObjectInputStream(fileInput);
                    }
                    catch(Exception e){
                        System.out.println(e.toString());
                        this.setFileLoadErrorFlag(true);
                    //  objectInput = null;
                      System.err.println("File input error" + e);

                }
            try {
                returnvar = objectInput.readObject();
            }catch(Exception e){
                System.out.println(e.toString());
            }
               if(returnvar == null){
                returnvar = new Object();
                }
            

		}
            return returnvar;
    }
    //============================================================
		public void openStreamOutput(Object var){
			ObjectOutputStream objectoutput = null;
		try{
			FileOutputStream fileInput = new FileOutputStream(getFileName());
	        objectoutput = new ObjectOutputStream(fileInput);
		}
		  catch (Exception e){
              this.setFileSaveErrorFlag(true);
			//  objectInput = null;
			  System.err.println("File input error" + e);

		}
        try {
            //objectoutput.
            objectoutput.writeObject(var);
        } catch (IOException ex) {
            System.out.println(ex.toString());
            //Logger.getLogger(stream.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            objectoutput.flush();
            objectoutput.close();
        } catch (IOException ex) {
           System.out.println(ex.toString());
            // Logger.getLogger(stream.class.getName()).log(Level.SEVERE, null, ex);
        }
	        //return objectoutput;

		}
        //===============================================================
        public boolean closeStream(ObjectInputStream object){
			boolean varreturn;
			try{
				object.close();
				varreturn = true;
			}
		catch(Exception e){
			System.err.println("File input error" + e);
			varreturn = false;
		}
		return varreturn;

	}
     //==================================================================
        public boolean closeStream(ObjectOutputStream object){
			boolean varreturn;
			try{
				object.close();
				varreturn = true;
			}
		catch(Exception e){
			System.err.println("File input error" + e.toString());
			varreturn = false;
		}
		return varreturn;

			}
        //===========================================================
        public Object FileLoadStream(ObjectInputStream objectInput){
            Object newNode = new Object();
			try
			{
	        int i = objectInput.readInt();
	         newNode = (Object) objectInput.readObject();

	         System.out.println(i +"readInt");
	         System.out.println(newNode + "node");

			}
							    catch (Exception e)
				{
					newNode = null;
				System.err.println("File input error" + e);

				}

			return newNode;

		}
        //================================================================
        public boolean FileSaveStream(Object var, ObjectOutputStream objectOutput){
				boolean returnvar;
			try{
		        SerializablePermission SerializablePermission = new SerializablePermission("SerializablePermission");
		        objectOutput.writeObject(SerializablePermission);
		        objectOutput.writeObject(var);
		        returnvar = true;
			}
			  catch (Exception e)
				{
				System.err.println("File save error" + e);
				returnvar = false;
				}
				return returnvar;
			}
        //===============================================================

}
