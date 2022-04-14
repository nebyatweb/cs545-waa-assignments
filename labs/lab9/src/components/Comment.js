const Comment = (props) => {
    return ( 
        <div className="comment">
            <p>Id: {props.id}</p>
            <p>Comment: {props.name}</p>
        </div>
     );
}
 
export default Comment;