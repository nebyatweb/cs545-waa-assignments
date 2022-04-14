import React, { useContext } from 'react';
import "./post.css";
import { PostContext } from '../store/PostContext';

const Post = (props) => {
    const {setSelectedPostIdState} = useContext(PostContext);
    return ( 
        <div className="content" key={props.id} onClick={() => setSelectedPostIdState(props.id)}>
             <span>Id: </span>{props.id} <br/>
             <span>Title: </span>{props.title} <br/>
             <span>Author: </span>{props.author} <br/>
         </div>
     );
}
 
export default Post;
