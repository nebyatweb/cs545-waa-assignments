import axios from "axios";
import Comments from "../containers/Comments";
import './postdetails.css'

const PostDetails = (props) => {
    const handleDelete = (id) => {
        axios.delete('http://localhost:8080/api/v1/users/1/posts/' + id).then(res => {
            props.changeFetchFlag();
        }).catch(error => {
            console.error(error);
        })
    }
    return ( 
        <div className="post-detail">
            <p> Posted by: {props.id}</p>

            <Comments id={props.id}></Comments>
            <button
                    onClick={() => {handleDelete(props.id)}}> 
                    Delete post
            </button>
        </div>
     );
}
 
export default PostDetails;
