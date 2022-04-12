 import {useState} from "react";

 const NewPost = (props) => {
     return (
         <div className="Content-new">
             <br/><input type="text"
                    label={'title'}
                    name={'title'}
                    onChange={props.onChange}
                    value={props.name}
                    />

            <br/><button onClick={props.addButtonClicked}>Change Name</button>
         </div>
     );
 }

 export default NewPost;