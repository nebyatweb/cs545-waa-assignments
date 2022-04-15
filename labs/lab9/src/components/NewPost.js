import axios from "axios";
import { useRef } from "react";
import './newpost.css'


const NewPost = (props) => {
    const newPostForm = useRef();

    const handleClick = () => {
        const form = newPostForm.current;

        const data = {
            title: form['title'].value,
            content: form['content'].value,
            author: form['author'].value
        }
        if(data.title === '' && data.content=== '' && data.author === '')
        return 
            axios.post('http://localhost:8080/api/v1/users/1/posts', data).then(res => {
                form['title'].value=''
                form['content'].value='' 
                form['author'].value=''
                props.changeFetchFlag();
            }).catch()
    }
    return ( 
        <div className="new-post">
            <div>
                <label >Title</label>
                <input type="text" label={'title'} name={'title'}/>
            </div>
            <div>
                <label >Content</label>
                <input type="text" label={'content'} name={'content'}/>
            </div>
            <div>
                <label >Author</label>
                <input type="text" label={'author'} name={'author'}/>
            </div>
            <div>
                <button onClick={handleClick}>Add Post</button>
            </div>
            
        </div>
     );
}
 
export default NewPost;