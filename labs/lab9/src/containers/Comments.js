import axios from "axios";
import { useState, useEffect } from "react";
import Comment from "../components/Comment";


const Comments = (props) => {
    const [postComments, setPostComments] = useState({});
    useEffect( () =>{
        if(props.id !== 0)
            axios.get('http://localhost:8080/api/v1/comments/' + props.id)
                 .then(res => {
                     setPostComments(res.data)
                 }).catch(error => console.log(error))
    },[props.id])

    let comments = null;
    if(props.id !== 0) {
        comments = (Object.keys(postComments).length === 0) ? null : postComments.map(comment => {
            return <Comment id={comment.id} name={comment.name}/>
        });
    }
    return ( 
        <div className="comments">
            {comments}
        </div>
     );
}
 
export default Comments;