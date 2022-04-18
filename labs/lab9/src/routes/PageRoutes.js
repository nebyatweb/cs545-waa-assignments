import { Route, Routes } from "react-router";
import NewPost from "../components/NewPost";
import PostDetails from "../components/PostDetails";
import Posts from "../containers/Posts";

const PageRoutes = () => {
  return (
    <Routes>
      <Route path="posts" element={<Posts />}>
        <Route path=":id" element={<PostDetails />} />
      </Route>

      <Route path="create-post" element={<NewPost />} />
    </Routes>
  );
};

export default PageRoutes;
