import { useState } from "react";
import PostDetails from "./components/PostDetails";
import Posts from "./containers/Posts";
import NewPost from "./components/NewPost";
import { PostContext } from "./store/PostContext";

const Dashboard = () => {
    const [fetchFlag, setFetchFlag] = useState(true);
    const [selectedPostIdState, setSelectedPostIdState] = useState(0);
    const changeFetchFlag = () => {
        setFetchFlag(!fetchFlag);
    }


    return ( 
        <div className="header">
            <PostContext.Provider value={{selectedPostIdState, setSelectedPostIdState}}>
            <Posts fetchFlag={fetchFlag}/>
            <div>
                <PostDetails changeFetchFlag={changeFetchFlag} />
            </div>
            </PostContext.Provider>
            <div>
                <NewPost changeFetchFlag={changeFetchFlag} />
            </div>
        </div>
     );
}

export default Dashboard;