import axios from "axios";
import { useState } from "react";
import './newpost.css'


const NewPost = (props) => {
    const [postState, setPostState] = useState(
        {title: '', content: '', author: ''}
    )

    const onChange = (e) => {
        const updatePost = {...postState, [e.target.name]: e.target.value}
        setPostState(updatePost);
    }

    const handleClick = () => {
        if(postState.title === '' && postState.content=== '' && postState.author === '')
        return 
            axios.post('http://localhost:8080/api/v1/posts', postState).then(res => {
                setPostState({title: '', content: '', author: ''});
                props.changeFetchFlag();
            }).catch()
    }
    return ( 
        <div className="new-post">
            <div>
                <label >Title</label>
                <input type="text" label={'title'} name={'title'} onChange={onChange} value={postState.title}/>
            </div>
            <div>
                <label >Content</label>
                <input type="text" label={'content'} name={'content'} onChange={onChange} value={postState.content}/>
            </div>
            <div>
                <label >Author</label>
                <input type="text" label={'author'} name={'author'} onChange={onChange} value={postState.author}/>
            </div>
            <div>
                <button onClick={handleClick}>Add Post</button>
            </div>
            
        </div>
     );
}
 
export default NewPost;