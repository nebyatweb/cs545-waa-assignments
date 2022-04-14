import React from 'react';
import "./post.css";

const Post = (props) => {
    return ( 
        <div className="content">
             <span>Id: </span>{props.id} <br/>
             <span>Title: </span>{props.title} <br/>
             <span>Author: </span>{props.author} <br/>
         </div>
     );
}
 
export default Post;
